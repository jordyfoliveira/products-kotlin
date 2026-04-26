package com.example.product_springboot.dto

import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class UpdatePriceRequest(
    @field:Positive
    val price: BigDecimal
)