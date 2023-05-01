package com.example.mvc.validator

import com.example.mvc.annotation.StringFormatDateType
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class StringFormatDateTimeValidator:ConstraintValidator<StringFormatDateType,String> {
    private  var pattern :String?=null
    override fun initialize(constraintAnnotation: StringFormatDateType?) {
        this.pattern=constraintAnnotation?.pattern
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return try{
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
            true
        }catch (e:Exception){
            false
        }
    }

}