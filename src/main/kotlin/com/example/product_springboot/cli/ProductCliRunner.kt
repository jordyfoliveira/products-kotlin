package com.example.product_springboot.cli

import com.example.product_springboot.service.ProductService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.Scanner
import org.springframework.web.server.ResponseStatusException

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
                "1" -> {
                    val products = productService.getAllProducts()

                    if (products.isEmpty()) {
                        println("Nenhum produto encontrado")
                    } else {
                        products.forEach {
                            println("ID: ${it.id} | SKU: ${it.sku} | Nome: ${it.name} | Preço: ${it.price} | Stock: ${it.stock}")
                        }
                    }
                }
                "2" -> {
                    print("Introduza o ID do produto: ")
                    val idInput = scanner.nextLine()

                    val id = idInput.toLongOrNull()

                    if (id == null) {
                        println("ID inválido.")
                    } else {
                        try {
                            val product = productService.getProductById(id)

                            println(
                                "ID: ${product.id} | SKU: ${product.sku} | Nome: ${product.name} | " +
                                        "Descrição: ${product.description} | Preço: ${product.price} | Stock: ${product.stock}"
                            )
                        } catch (ex: ResponseStatusException) {1
                            println(ex.reason ?: "Produto não encontrado")
                        }
                    }
                }
                "0" -> return
                else -> println("Opção inválida")
            }
        }
    }
}