package com.example.product_springboot.controller

import com.example.product_springboot.dto.CreateProductRequest
import com.example.product_springboot.dto.UpdatePriceRequest
import com.example.product_springboot.dto.UpdateStockRequest
import com.example.product_springboot.model.Product
import com.example.product_springboot.repository.ProductRepository
import jakarta.validation.Valid
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@RestController
class ProductController(private val productRepository: ProductRepository) {
//class ProductController(private val productRepository: ProductRepository) { ->older version

    @GetMapping("/products")
    fun getProducts(): List<Product> {
        return productRepository.findAll(Sort.by("id"))
    }

    @GetMapping("/products/{id}")
    fun getProduct(@PathVariable id: Long): Product {
        return productRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }
    }

    @PostMapping("/products")
    fun createProduct(@RequestBody @Valid request: CreateProductRequest): Product {

        if (productRepository.existsBySku(request.sku)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "SKU já existente")
        }

        val product = Product().apply {
            sku = request.sku
            name = request.name
            description = request.description
            price = request.price
            stock = request.stock
            updatedAt = LocalDateTime.now().toString()
        }

        return productRepository.save(product)
    }

    @PatchMapping("/products/{id}/stock")
    fun updateStock(@PathVariable id: Long, @RequestBody @Valid request: UpdateStockRequest): Product {
        val product = productRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }

        product.stock = request.stock
        product.updatedAt = LocalDateTime.now().toString()

        return productRepository.save(product)
    }

    @PatchMapping("/products/{id}/price")
    fun updatePrice(@PathVariable id: Long, @RequestBody @Valid request: UpdatePriceRequest): Product {
        val product = productRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }

        product.price = request.price
        product.updatedAt = LocalDateTime.now().toString()

        return productRepository.save(product)
    }

    @DeleteMapping("/products/{id}")
    fun deleteProduct(@PathVariable id: Long): Map<String, String> {

        //val product = productRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }
        //return productRepository.delete(product)

        if (!productRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        }

        productRepository.deleteById(id)

        return mapOf("message" to "Produto removido com sucesso")
    }
}