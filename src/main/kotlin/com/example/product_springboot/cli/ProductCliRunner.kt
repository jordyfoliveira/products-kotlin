package com.example.product_springboot.cli

import com.example.product_springboot.service.ProductService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.Scanner

@Component
class ProductCliRunner (private val productService: ProductService) : CommandLineRunner {

    override fun run(vararg args: String) {
        menu()
    }

    fun menu(){
        val scanner = Scanner(System.`in`)

        while(true) {
            println("1) Listar produtos")
            println("2) Ver produto por ID")
            println("0) Sair")

            val option = scanner.nextLine()

            when(option){
                "1" -> println("Listar produtos")
                "2" -> println("Ver produto por ID")
                "0" -> return
                else -> println("Opção inválida")
            }
        }
    }
}