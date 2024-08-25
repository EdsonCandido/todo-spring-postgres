package com.zuko.TodoList.service;

import com.zuko.TodoList.entity.Todo;
import com.zuko.TodoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        this.todoRepository.save(todo);
        return listAll();
    }
    public List<Todo> listAll(){
       Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
       return this.todoRepository.findAll(sort);

    }
    public Optional<Todo> findOne(Long id){
        return this.todoRepository.findById(id);
    }
    public Todo update(Todo todo){
        return this.todoRepository.save(todo);
    }
    public String deleteOne(Long id){
        Optional<Todo> todo =  this.todoRepository.findById(id);

        if(todo.isPresent()){
            return "not found";
        }

        todo.get().setDeleted(1);

        this.todoRepository.save(todo.get());

        return "deleted";
    }
}
