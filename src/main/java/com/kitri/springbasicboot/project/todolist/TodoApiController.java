package com.kitri.springbasicboot.project.todolist;

import com.kitri.springbasicboot.project.todolist.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    static HashMap<Integer, Todo> todos = new HashMap<>() ;
    static int id = 6;
    static {
        todos.put(1, new Todo(1, "Todolist 만들기", "false"));
        todos.put(2, new Todo(2, "정동진 놀러가기", "false"));
        todos.put(3, new Todo(3, "생일파티 하기", "false"));
        todos.put(4, new Todo(4, "코딩테스트 문제 풀기", "true"));
        todos.put(5, new Todo(5, "자격증 공부하기", "false"));
    }
    @GetMapping("")
    public ArrayList<Todo> todos() {
        return new ArrayList<>(todos.values());
    }
    @PostMapping("/addTodo")
    public boolean add(@RequestBody Todo todo) {
        todo.setId(id);
        return todos.put(id++, todo) != null ? true : false;
    }

//map에 등록
//html에서 업데이트 (추가한 데이터 삽입)
    @PostMapping ("/updateTodo")
    public void update(@RequestBody Todo todo){
        todos.get(todo.getId()).setChk(todo.chk);
    }

    //리스트 삭제하기
    @PostMapping("/deleteTodo")
    public void delete(@RequestBody Todo todo){
        todos.remove(todo.id);
    }

}
