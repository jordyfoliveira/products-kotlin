package com.example.product_springboot.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException::class)
    fun handle(ex: ResponseStatusException): ResponseEntity<Map<String, Any?>> {

        val body = mapOf(
            "status" to ex.statusCode.value(),
            "error" to ex.statusCode.toString(),
            "message" to ex.reason
        )

        return ResponseEntity.status(ex.statusCode).body(body)
    }
}