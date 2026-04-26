package com.example.product_springboot.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import java.math.BigDecimal

data class CreateProductRequest(
    @field:Pattern(regexp = "^SKU\\d{3}$")
    @field:NotBlank
    val sku: String,

    @field:Size(min = 3)
    @field:NotBlank
    val name: String,

    val description: String = "",

    @field:Positive
    val price: BigDecimal,

    @field:Positive
    val stock: Int
)