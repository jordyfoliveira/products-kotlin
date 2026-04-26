package com.example.product_springboot.service

import com.example.product_springboot.dto.UpdateStockRequest
import com.example.product_springboot.model.Product
import com.example.product_springboot.repository.ProductRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun getAllProducts(): List<Product>{
        return productRepository.findAll(Sort.by("id"))
    }

    fun getProductById(id: Long): Product{
        return productRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }
    }

    fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    fun deleteProductById(id: Long){
        return productRepository.deleteById(id)
    }
}