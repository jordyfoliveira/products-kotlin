package com.example.product_springboot.controller

import com.example.product_springboot.dto.CreateProductRequest
import com.example.product_springboot.dto.UpdatePriceRequest
import com.example.product_springboot.dto.UpdateStockRequest
import com.example.product_springboot.model.Product
import com.example.product_springboot.service.ProductService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(private val productService: ProductService) {
//class ProductController(private val productRepository: ProductRepository) { ->older version

    @GetMapping("/products")
    fun getProducts() = productService.getAllProducts()

    @GetMapping("/products/{id}")
    fun getProduct(@PathVariable id: Long): Product = productService.getProductById(id)

    @PostMapping("/products")
    fun createProduct(@RequestBody @Valid request: CreateProductRequest) = productService.createProduct(request)

    @PatchMapping("/products/{id}/stock")
    fun updateStock(@PathVariable id: Long, @RequestBody @Valid request: UpdateStockRequest) = productService.updateStock(id, request)

    @PatchMapping("/products/{id}/price")
    fun updatePrice(@PathVariable id: Long, @RequestBody @Valid request: UpdatePriceRequest) = productService.updatePrice(id, request)

    @DeleteMapping("/products/{id}")
    fun deleteProduct(@PathVariable id: Long) = productService.deleteProduct(id)
}