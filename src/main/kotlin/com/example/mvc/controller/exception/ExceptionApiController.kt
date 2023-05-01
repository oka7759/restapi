package com.example.mvc.controller.exception

import com.example.mvc.controller.model.http.ErrorResponse
import com.example.mvc.controller.model.http.UserRequest
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/exception")
@Validated
class ExceptionApiController {
    @GetMapping("/hello")
    fun hello(): String {
//
//     val list = mutableListOf<String>()
//    val temp =list[0]
        return "hello"
    }
    @GetMapping("")
    fun get(@NotBlank
    @Size(min=2, max = 4)
            @RequestParam name:String,

            @Min(value = 10)
            @RequestParam age:Int): String {
        println(name)
        println(age)
        return name+" "+age
    }
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun constraintViolatioonException(e:ConstraintViolationException,request:HttpServletRequest):ResponseEntity<ErrorResponse>{
        val errors = mutableListOf<ErrorResponse.Error>()
        e.constraintViolations.forEach{

            val error=ErrorResponse.Error().apply {
                this.field = it.propertyPath.last().name
                this.message=it .message
                this.value=it.invalidValue
            }
            errors.add(error)
        }

        val errorResponse =ErrorResponse().apply {
            this.resultCode="FAIL"
            this.httpStatus=HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod=request.method
            this.message="요청에 에러가 있음"
            this.path=request.requestURI.toString()
            this.timestamp = LocalDateTime.now()
            this.errors=errors
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }
    @PostMapping("")
    fun post (@Valid @RequestBody userRequest: UserRequest):UserRequest{
        println(userRequest)
        return userRequest

    }
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValidException (e:MethodArgumentNotValidException,request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val errors = mutableListOf<ErrorResponse.Error>()
        e.bindingResult.allErrors.forEach{ errorObj ->
            val error =ErrorResponse.Error().apply {
                this.field=(errorObj as FieldError).field
                this.message=errorObj.defaultMessage
                this.value=errorObj.rejectedValue
            }
            errors.add(error)

        }
        val errorResponse =ErrorResponse().apply {
            this.resultCode="FAIL"
            this.httpStatus=HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod=request.method
            this.message="요청에 에러가 있음"
            this.path=request.requestURI.toString()
            this.timestamp = LocalDateTime.now()
            this.errors=errors
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)


    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOuutOfBoundsException(): ResponseEntity<String> {
        println("controller exception")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("idex error")
    }
}