package com.example.mvc.controller.page

import com.example.mvc.controller.model.http.UserRequest
import com.example.mvc.controller.model.http.UserResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {
    @GetMapping("/main")
    fun main(): String {
        return "main.html"

    }

    @ResponseBody    //컨트롤러 이노테이션에서 restapi 내릴때 사용
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name ="ssss"
        }

    }
}