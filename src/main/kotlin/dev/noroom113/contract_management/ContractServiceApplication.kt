package dev.noroom113.contract_management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
class ContractManagementApplication

fun main(args: Array<String>) {
    runApplication<ContractManagementApplication>(*args)
}
