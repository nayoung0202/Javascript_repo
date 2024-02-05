package com.kitri.springbasicboot.lesson.mapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;

@Controller
public class MappingController {
    //@ResponseBody : return 값을 responsebody안에 넣겠다는 것
    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "hello";
        //view 이름
    }

    @GetMapping("/get2")
    public String get2(Model model){
        model.addAttribute("message", "GET2");

        return "/lesson/mapping";
    }

    @GetMapping("/get3")
    public String get3(HttpServletRequest resquest){
        resquest.setAttribute("message", "GET3");

        return "/lesson/mapping";
    }

    //특정 메소드일때만 받는 것
    //ReqyestMethod.GET == HttpServletRequest resquest
    //but,
    @RequestMapping(value = "/get4", method = RequestMethod.GET)
    public ModelAndView get4(ModelAndView mv){
        mv.addObject("message", "GET4") ;
        mv.setViewName("/lesson/mapping");
        return mv;
    }
    @RequestMapping(
            value = {"/a", "/b","c"},
            method = {RequestMethod.GET, RequestMethod.POST})
    public String multiURL(Model model){
        model.addAttribute("message", "MULTI_URL_MAPPING");
        return "/lesson/mapping";
    }

    @PostMapping("/post")
    public String post(Model model){
        model.addAttribute("message", "POST");
        return "/lesson/mapping";
    }

    @PutMapping("/put")
    public String put(Model model){
        model.addAttribute("message", "POST");
        return "/lesson/mapping";
    }

    @DeleteMapping ("/delete")
    public String delete(Model model){
        model.addAttribute("message", "DELETE");
        return "/lesson/mapping";
    }


}
