package com.example.mvc.controller.put

import com.example.mvc.controller.model.http.Result
import com.example.mvc.controller.model.http.UserRequest
import com.example.mvc.controller.model.http.UserResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
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
    fun putMappingObj (@RequestBody userRequest: UserRequest): UserResponse {

       return UserResponse().apply {
            this.result= Result().apply {
                this.resultCode="OK"
                this.resultMessage= "성공"
            }
        }.apply {
            this.description = "응답입니다."
        }.apply {
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name="a"
                this.age=11
                this.phoneNumber="010-111"
                this.email ="이메일"
                this.address="수원시"
            })
            userList.add(UserRequest().apply {
                this.name="b"
                this.age=112
                this.phoneNumber="010-111222"
                this.email ="이메일2"
                this.address="수원시2"
            })
            userList.add(UserRequest().apply {
                this.name="c"
                this.age=1133
                this.phoneNumber="010-11133"
                this.email ="이메일3"
                this.address="수원시3"
            })
            this.userRequest=userList

        }




    }
}