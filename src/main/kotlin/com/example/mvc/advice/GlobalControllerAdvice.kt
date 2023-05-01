package com.example.mvc.advice

import com.example.mvc.controller.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// @RestControllerAdvice(basePackageClasses = [ExceptionApiController::class])
class GlobalControllerAdvice {
    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(): String {
        return "Server Error"
    }
    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOuutOfBoundsException(): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("idex error")
    }
}