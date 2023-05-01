package com.example.mvc.controller.model.http

import com.example.mvc.annotation.StringFormatDateType
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.AssertFalse
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import org.springframework.cglib.core.Local
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Properties

data class UserRequest(

        @field:NotEmpty
        @field:Size(min = 2 , max = 8)
        var name:String?=null,

        @field:PositiveOrZero // 0 < 숫자를 검증 0 도 포함 (양수)
        var age:Int?=null,

        @field:Email    // email 양식
        var email:String?=null,

        @field:NotBlank // 공백을 검증
        var address:String?=null,

        @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")  // 정규식 검증
        var phoneNumber:String?=null,    // phone_number
        @field:StringFormatDateType(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
        var createdAt:String?=null  // yyyy-MM-dd HH:mm:ss   ex) 2020-10-02 13:00:00
)