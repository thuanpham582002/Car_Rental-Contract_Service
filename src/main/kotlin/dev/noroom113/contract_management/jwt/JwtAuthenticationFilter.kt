package dev.noroom113.contract_management.jwt

import dev.noroom113.contract_management.jwt.interceptor.JwtInterceptor
import dev.noroom113.contract_management.entites.UrlAccessable
import dev.noroom113.contract_management.jwt.util.JwtUtil
import dev.noroom113.contract_management.jwt.util.getBearerToken
import dev.noroom113.contract_management.jwt.util.hasAccess
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtUtil: JwtUtil,
    private val interceptors: List<JwtInterceptor>,
) : OncePerRequestFilter() {
    companion object{
        val WHITE_LIST = setOf<UrlAccessable>(
            UrlAccessable("/swagger-resources/**"),
            UrlAccessable("/swagger-ui.html/**"),
            UrlAccessable("/swagger-resources/**"),
            UrlAccessable("/swagger-ui/**"),
            UrlAccessable("/v3/api-docs/**"),
        )
    }
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        if (request.hasAccess(WHITE_LIST)) {
            filterChain.doFilter(request, response)
            return
        }
        for (interceptor in interceptors) {
            interceptor.intercept(request, response)
        }
        request.getBearerToken()?.let {
            response.setHeader("Authorization", jwtUtil.refreshToken(it))
        }
        filterChain.doFilter(request, response)
    }
}