package com.example.product_springboot.repository

import com.example.product_springboot.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    fun existsBySku(sku: String): Boolean
}