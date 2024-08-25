package com.zuko.TodoList.controller;

import com.zuko.TodoList.entity.Todo;
import com.zuko.TodoList.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public List<Todo> create( @RequestBody Todo todo){
        return this.todoService.create(todo);
    }

    @GetMapping
    public List<Todo> listAll(){
        return this.todoService.listAll();
    }

    @GetMapping("{id}")
    public Optional<Todo> findOne( @PathVariable("id") Long id){
        return this.findOne(id);
    }

    @PutMapping
    public Todo update( @RequestBody Todo todo){
        return this.todoService.update(todo);
    }
}
