package com.kitri.springbasicboot.lesson.hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    //필드 주입
    @Autowired
    Greeting greeting;

    //Setter 주입
//    @Autowired
//    public void setGreeting(Greeting greeting) {
//        this.greeting = greeting;
//    }

    //생성자 주입
    //@Autowired
//    public GreetingController(Greeting greeting) {
//        this.greeting = greeting;
//    }
    @Qualifier("englishGreeting")
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", greeting.hello());
        return "greeting";
    }
}
