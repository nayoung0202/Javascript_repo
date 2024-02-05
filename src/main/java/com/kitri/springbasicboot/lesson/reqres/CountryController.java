package com.kitri.springbasicboot.lesson.reqres;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

//Bean으로 등록
@RestController
//맨 앞의 주소 고정
@RequestMapping("/countries")
public class CountryController {
    static HashMap<String, Country> countries = new HashMap<>();
    static {
        countries.put("한국", new Country("한국", "서울"));
        countries.put("미국", new Country("미국", "워싱턴DC"));
        countries.put("프랑스", new Country("프랑스", "파리"));
        countries.put("몽골", new Country("몽골", "울린바토르"));
        countries.put("아르헨티나", new Country("아르헨티나", "부에노스아이레스"));
    }

    //전체 리스트를 리턴
    @GetMapping
    public ArrayList<Country> countries(){
        return new ArrayList<>(countries.values());
    }

//    @PostMapping("")
    public Country addCountry(@RequestParam String name, @RequestParam String capital){
        countries.put(name, new Country(name, capital));
//josn은 못 읽는다.
        return countries.get(name);
    }

//    @PostMapping("")
    public Country addCountry2(@RequestBody Country country){
        //json, 객체로 변환해서 받는다.
        countries.put(country.getName(), country);

        return countries.get(country.getName());
    }

    @PostMapping("")
    public Country addCountry3(@ModelAttribute Country country){
        //파라미터 형식으로 요청이 왔을 때만 받음
        countries.put(country.getName(), country);
//josn은 못 읽는다.
        return countries.get(country.getName());
    }


    @PostMapping("/4")
    public ResponseEntity<Country> anddCountry4(@ModelAttribute Country country){
        countries.put(country.getName(), country);
/*        return ResponseEntity.ok(countries.get(country.getName()));*/
        return new ResponseEntity<>(countries.get(country.getName()), HttpStatus.UNAUTHORIZED);
    }
}
