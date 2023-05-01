package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")

class DeleteApiController {

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
            @RequestParam name: String,@RequestParam age:Int
    ): String {
        println(name)
        println(age)
        return name +""+age

    }

    @DeleteMapping("/delete-mappinmg/name/{name}/age/{age}")
    fun deleteMappinPath (@PathVariable name: String,@PathVariable age:Int): String {

        println(name)
        println(age)
        return name +""+age
    }
}