package com.example.mvc.controller.response

import com.example.mvc.controller.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/response")
class ResponseApiController {
    @GetMapping("")

    fun getMapping(@RequestParam age:Int?): ResponseEntity<String> {
        return age?.let {
            if(age<20){
                return  ResponseEntity.status(400).body("20이상입력")
            }
            ResponseEntity.ok("OK")


        }?:kotlin.run {
            return  ResponseEntity.status(400).body("값누락")
        }


//        if (age == null){
//            return  ResponseEntity.status(400).body("값누락")
//
//        }
//        if(age<20){
//            return  ResponseEntity.status(400).body("fail")
//        }
//        return ResponseEntity.ok("Ok")

    }
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest)
    }
    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id :Int): ResponseEntity<Nothing> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }

}