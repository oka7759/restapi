package com.example.mvc.controller.put

import com.example.mvc.controller.model.http.Result
import com.example.mvc.controller.model.http.UserRequest
import com.example.mvc.controller.model.http.UserResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder
import kotlin.Result.Companion as Result1

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping (): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], value = ["/request-mapping"])
    fun requestMapping(): String {
        return "request"
    }

    @PutMapping("/put-mapping/obj")
    fun putMappingObj (@Valid @RequestBody userRequest: UserRequest, bindingResult:BindingResult): ResponseEntity<String> {
        if(bindingResult.hasErrors()){

            var msg =StringBuilder()
            bindingResult.allErrors.forEach{
                val field = it as FieldError
                val message= it.defaultMessage
                msg.append(field.field.toString()+" : "+message+"\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())

        }

return ResponseEntity.ok("성공")


    }
}