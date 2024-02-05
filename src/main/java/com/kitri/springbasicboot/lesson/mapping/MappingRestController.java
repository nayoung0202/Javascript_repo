package com.kitri.springbasicboot.lesson.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/students") //localhost:8080/students로 들어오면 매칭됨
public class MappingRestController {
    static HashMap<Long, Student > students = new HashMap<>();
    //Hashmap : 키,id
    static {
        students.put(1L, new Student(1L, "박준혁"));
        students.put(2L, new Student(2L, "주나영"));
        students.put(3L, new Student(3L, "김성실"));
        students.put(4L, new Student(4L, "한민선"));
    }
    @GetMapping("/student")
    public String student(){

        return "학생";
    }

    //id가 동적이기 때문에 중괄호로 묶어서 동적인 값으로 받는다.
    //특정 학생 1명 조회
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        //Long id를 읽겠다는 것 (@PathVaruable)

        //Student에 getter를 추가하여 id를 받아옴
        //객체를 리턴 -> 응답 : JSON
        return students.get(id);
    }
    @GetMapping("")
    public ArrayList<Student> getAll(){
        //map의 value를 arraylist로 변경
        return new ArrayList<Student>(students.values());
    }

    //POST는 클라이언트에서 데이터를 보냄(전송)(데이터의 타입, json : {"application/json"})
    @PostMapping(path = "", consumes = {"application/json"})
    // 등록 요청
    public Long addstudent(){
        //map의 value를 arraylist로 변경
        new Student(5L, "김미성");
        return 5L;
    }

    //서버에서 응답하는 데이터 타입을 제한
    @GetMapping(path = "/produces", produces = {"application/json"})
    public String produces(){
        return "OK";
    }

}
