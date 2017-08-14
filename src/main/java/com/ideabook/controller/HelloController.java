package com.ideabook.controller;

import com.ideabook.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lzh
 * @Description:
 * @Date: Created in 2017/8/10 10:30
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloGet(){
        return "hello!!!";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String helloPost(String name){
        return  name + " ,hello!!!";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.PUT)
    public String helloPut(@RequestBody User user){
        return user + " ,hello!!!";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.DELETE)
    public String helloDelete(@RequestBody User user){
        return user + " ,hello!!!";
    }
}
