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
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name="sku", unique = true, nullable = false)
    var sku: String = ""

    @Column(name="name", nullable = false)
    var name: String = ""

    @Column(name="description", nullable = false)
    var description: String = ""

    @Column(name="price", nullable = false)
    var price: BigDecimal = BigDecimal.ZERO

    @Column(name="stock", nullable = false)
    var stock: Int = 0

    @Column(name="isActive", nullable = false)
    var isActive: Boolean = true

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
}