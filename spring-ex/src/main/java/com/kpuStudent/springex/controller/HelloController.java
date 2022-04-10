package com.kpuStudent.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    //</hello> -> 메서드 호출
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";

    }

    //MVC Model,View,Controller & 템플릿 엔진00000
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API
    @ResponseBody       //http body부분에 이 데이터 넣겠다    @GetMapping("hello-string")

    public String helloString(@RequestParam("name") String name){
        return "hello " + name;     // "hello name"이 그대로 들어감 페이지 소스보기에서 확실하게 느낄 수 있음
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;       // {"name":"spring!!"} JSON 형태  <->xml방식은 너무 무거워요 json은 심플해요 그래서 json으로 거의 통일 됐어요
    }

    static class Hello{
        private String name;

        //property 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
