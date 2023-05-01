package com.example.mvc.controller.post

import com.example.mvc.controller.model.http.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController {
    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"

    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mappig"])
    fun requestMapping (): String {
        return "request-mapping"
    }

    @PostMapping("/post-mapping/obj")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }



}