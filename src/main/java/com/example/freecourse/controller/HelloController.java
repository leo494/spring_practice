package com.example.freecourse.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody //ResponseBody << http에 있는 body에 return에 있는 데이터를 직접 넣어주겠다.(html말고 http)
    //view같은거 없고(html없고) 그냥 보내고픈 data만 보내버림.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //첨으로 객체 넘김, json으로 넘어감(참고, json은 key, value로 이루어짐)
    }
    static class Hello{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}


