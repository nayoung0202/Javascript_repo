package com.kitri.springbasicboot.project.random_page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping("/random")
public class randomController {
    @GetMapping("/color")
    public String get(Model model){
        Random r = new Random();
        int n = r.nextInt();

        String Hexadecimal = Integer.toHexString(n);
        model.addAttribute("randomcolor", "#"+Hexadecimal);

        return "/project/random_page/random_page";
    }

    @ResponseBody
    @GetMapping("/number/{n}")
    public String get(@PathVariable int n) {
        ArrayList<Integer>number = new ArrayList<>();
        int m = (int)(Math.random()*n);
        number.add(m);

        return "번호 : " + number;
    }

}
