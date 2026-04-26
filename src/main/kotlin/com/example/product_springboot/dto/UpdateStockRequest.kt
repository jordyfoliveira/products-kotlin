package com.example.product_springboot.dto

import jakarta.validation.constraints.PositiveOrZero

data class UpdateStockRequest(
    @field:PositiveOrZero
    val stock: Int
)