package com.example.mvc.controller.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.Properties

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
//일괄 Json변수명으로 전환
data class UserRequest (
        var name: String? = null,
        var age:Int? = null,
        var email:String? = null,
        var address:String? = null,


        @JsonProperty("phone_number")
        // 각각 json 변수명과 변환
        var phoneNumber: String? = null,
)