package com.kitri.springbasicboot.lesson.mybatis.todolist;

import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import com.kitri.springbasicboot.lesson.mybatis.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    @Autowired
    TodoMapper todoMapper;

    @GetMapping("")
    public ArrayList<ResponseTodo> todos() {
        ArrayList<ResponseTodo> responseTodos = (ArrayList<ResponseTodo>) todoMapper.findAll();
        return responseTodos;

    }
    @PostMapping("/save") //id는 필요 없음
    public void add(@RequestBody RequestTodo todo) {
//        System.out.println(todo);
        todoMapper.save(todo);
    }
    @PostMapping("/update") //id 필요
    public void update(@RequestBody RequestTodo todo) {
        todoMapper.update(todo);
    }
    @PostMapping("/delete") //id 필요
    public void delete(@RequestBody RequestTodo todo) {
        todoMapper.deleteById(todo.getId());
    }

//map에 등록
//html에서 업데이트 (추가한 데이터 삽입)
//    @PostMapping ("/updateTodo")
//    public void update(@RequestBody Todo todo){
//        todos.get(todo.getId()).setChk(todo.chk);
//    }
//
//    //리스트 삭제하기
//    @PostMapping("/deleteTodo")
//    public void delete(@RequestBody Todo todo){
//        todos.remove(todo.id);
//    }

}
