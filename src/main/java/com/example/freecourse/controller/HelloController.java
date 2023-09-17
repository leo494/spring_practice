package com.example.freecourse.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //data가 hello로 치환됨. key와 value느낌
        return "hello";//hello.html한테 가서 랜더링 해라, 기본적으로 스프링부트는 템플릿폴더에서 찾는다.
    }

    @GetMapping("hello-mvc") //hello-mvc가 맵핑됨. 뇌피셜 : 뭔가 url에 적으면 밑의 코드가 실행되는 느낌
    public String helloMvc(@RequestParam("name") String name, Model model){ //@requestparam 때문에 name이 파라미터를 받아야함.get방식이기 때문에 url에서 ?name=아무말 이렇게 주면 됨.
        model.addAttribute("name", name);//model에선 이제 name에 아무말이 담기고 key인 name을 hello-template에서 찾아서 value인 아무말을 반환
        return "hello-template";//뇌피셜 : hello-template.html을 찾아감?
    }

}


