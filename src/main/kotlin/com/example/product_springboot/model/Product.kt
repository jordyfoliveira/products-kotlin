package com.example.product_springboot.model

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "products")
@JsonPropertyOrder("id", "sku", "name", "description", "price", "stock", "isActive", "createdAt", "updatedAt")
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(unique = true, nullable = false)
    var sku: String = ""

    @Column(nullable = false)
    var name: String = ""

    var description: String = ""

    @Column(nullable = false)
    var price: BigDecimal = BigDecimal.ZERO

    @Column(nullable = false)
    var stock: Int = 0

    @Column(name = "is_active")
    var isActive: Boolean = true

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    var updatedAt: String = "" // temporário como tinhas
}