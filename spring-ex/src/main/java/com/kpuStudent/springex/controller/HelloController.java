package com.kpuStudent.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")    //</hello> -> 메서드 호출
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";

    }
}
