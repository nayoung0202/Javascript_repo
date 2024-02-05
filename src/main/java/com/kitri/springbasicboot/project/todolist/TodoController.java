package com.kitri.springbasicboot.project.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/todolist")
public class TodoListController {

    @GetMapping
    public String todos() {
        return "/project/todo/todos";
    }
}
