package com.example.product_springboot.service

import com.example.product_springboot.dto.CreateProductRequest
import com.example.product_springboot.dto.UpdatePriceRequest
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

    fun createProduct(request: CreateProductRequest): Product {

        if (productRepository.existsBySku(request.sku)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "SKU já existente")
        }

        val product = Product().apply {
            sku = request.sku
            name = request.name
            description = request.description
            price = request.price
            stock = request.stock
            createdAt = LocalDateTime.now()
            updatedAt = null
        }

        return productRepository.save(product)
    }

    fun updateStock(id: Long, request: UpdateStockRequest): Product{
        val product = getProductById(id)

        product.stock = request.stock
        product.updatedAt = LocalDateTime.now()

        return productRepository.save(product)
    }

    fun updatePrice(id: Long, request: UpdatePriceRequest): Product{
        val product = getProductById(id)

        product.price = request.price
        product.updatedAt = LocalDateTime.now()

        return productRepository.save(product)
    }

    fun deleteProduct(id: Long): Map<String, String>{

        val product = getProductById(id)

        productRepository.delete(product)

        return mapOf("message" to "Produto removido com sucesso")
    }
}