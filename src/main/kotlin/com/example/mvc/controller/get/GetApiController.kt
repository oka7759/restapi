package com.example.mvc.controller.get

import com.example.mvc.controller.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController   //REST APIController로 동작
@RequestMapping("/api")
class GetApiController {
    @GetMapping("/hello")
    fun hello():String{
        return "hellow kotlin"
    }
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMappig(): String {
        return "request-mapping"
    }
    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name:String,@PathVariable age:Int): String {
        println("${name},${age}")
        return name+""+age
    }
    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") _name:String,@PathVariable(value = "age") _age:Int): String {
        println("${_name},${_age}")
        return _name+""+_age
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
            @RequestParam name:String,
            @RequestParam age:Int
    ): String {
        println("${name},${age}")
        return name+""+age
    }
    
    @GetMapping("/get-mapping/obj")
    fun queryParamObj(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest

        
    }
    @GetMapping("/get-maping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String, Any> {
        println(map)
        return map

    }
}