package com.kitri.springbasicboot.lesson.reqres;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//Bean으로 등록
@Controller
//맨 앞의 주소 고정
@RequestMapping("/countries")
public class RequestResponseController {
    static HashMap<String, String> countries = new HashMap<>();
    static {
        countries.put("한국", "서울");
        countries.put("미국", "워싱턴DC");
        countries.put("프랑스", "파리");
        countries.put("몽골", "울란바토르");
        countries.put("아르헨티나", "부에노스아이레스");
    }
static HashMap<String, Country> countries2 = new HashMap<>();
    //기존에는 String을 Country라는 객체로 변경
    static {
        countries2.put("한국", new Country("한국", "서울"));
        countries2.put("미국", new Country("미국", "워싱턴DC"));
        countries2.put("프랑스", new Country("프랑스", "파리"));
        countries2.put("몽골", new Country("몽골", "울린바토르"));
        countries2.put("아르헨티나", new Country("아르헨티나", "부에노스아이레스"));
    }

    //국가와 수도를 매핑하여 반환해주는 메소드 만들기
    @GetMapping("/{name}")
    public String searchCapital(@PathVariable String name, Model model){
        //국가와 수도를 같이 넘겨줌
        String capital = countries.get(name);
        if (capital == null){
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("name", name);
        model.addAttribute("capital", capital);

        return "/lesson/reqres/countries"; //view 네임

    }

    @GetMapping("/searchCapital")
    public String searchCapital2(String name, Model model){
        //파라미터로 name을 넘겨준다.

        String capital = countries.get(name);
        if (capital == null){
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("name", name);
        model.addAttribute("capital", capital);

        return "/lesson/reqres/countries"; //view 네임
    }

    //국가와 수도를 등록
    @PostMapping("/addCountry")
    public String addCountry(@RequestParam String name,@RequestParam String capital){
        countries.put(name, capital);

        //redirect
        return "redirect:/" + name; //view 네임
    }

    @PostMapping("/addCountry2")
    public void addCountry2(@RequestBody Country country){
    //Body는 데이터를 가져올 수 없다. -> RequestBody는 객체를 읽을 때 사용
        countries2.put(country.getName(), country);

    }
}
