package dev.noroom113.contract_management.entites

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.sql.Date

@Entity
data class RentalContract(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val startDate : Date,
    val endDate : Date,
    val carId : Long,
    val customerId : Long,
    val staffId : Long?,
)
