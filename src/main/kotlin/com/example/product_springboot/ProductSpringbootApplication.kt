package com.example.product_springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductSpringbootApplication

fun main(args: Array<String>) {
    runApplication<ProductSpringbootApplication>(*args)
}
