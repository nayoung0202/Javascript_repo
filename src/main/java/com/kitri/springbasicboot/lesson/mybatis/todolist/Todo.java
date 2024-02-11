package com.kitri.springbasicboot.lesson.mybatis.todolist;

public class Todo {
    int id;
    String todo;
    String chk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getChk() {
        return chk;
    }

    public void setChk(String chk) {
        this.chk = chk;
    }

    public Todo(int id, String todo, String chk) {
        this.id = id;
        this.todo = todo;
        this.chk = chk;
    }
}
