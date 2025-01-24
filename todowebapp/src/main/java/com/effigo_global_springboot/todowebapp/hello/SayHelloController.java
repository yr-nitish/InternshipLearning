package com.effigo_global_springboot.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    //"say-hello" => "Hello ! What are you learning today?"

    //http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello()
    {
        return "Hello! What are you learning today?";
    }

    //"say-hello-jsp" => sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp()
    {
        return  "sayHello";
    }

    // say-hello-jsp => SayHelloController - sayHelloJsp method
}
