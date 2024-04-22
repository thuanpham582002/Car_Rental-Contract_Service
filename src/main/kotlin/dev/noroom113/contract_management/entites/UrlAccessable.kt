package dev.noroom113.contract_management.entites

import java.io.Serializable

data class UrlAccessable(
    val method: Set<HttpMethod>,
    val uri: String,
) : Serializable

enum class HttpMethod {
    GET, POST, PUT, DELETE, ALL
}
