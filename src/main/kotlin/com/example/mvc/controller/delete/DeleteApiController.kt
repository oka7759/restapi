package com.example.mvc.controller.delete

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
            @RequestParam name: String,
            @NotNull("age 가 누락")
            @Min(value = 20, message = "20보다 커야합니다.")
            @RequestParam age:Int
    ): String {
        println(name)
        println(age)
        return name +""+age

    }

    @DeleteMapping("/delete-mappinmg/name/{name}/age/{age}")
    fun deleteMappinPath (@PathVariable
                          @NotNull
    @Size(min=2, max = 5, message = "크기가 틀ㅕㅆ어")
                          name: String
                          ,
                          @NotNull("age 가 누락")
                          @Min(value = 20, message = "20보다 커야합니다.")
                          @PathVariable age:Int): String {

        println(name)
        println(age)
        return name +""+age
    }
}