package dev.noroom113.contract_management.repository

import dev.noroom113.contract_management.entites.RentalContract
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RentalContractRepository : JpaRepository<RentalContract, Long> {

}
