package org.spring.todorecap.controller;


import org.spring.todorecap.model.ToDo;
import org.spring.todorecap.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    public final ToDoService todoService;

    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<ToDo> getTodos(){
        return todoService.getAllToDos();
    }

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable String id){
        return todoService.getToDoById(id);
    }

    @PostMapping
    public ToDo addToDo(@RequestBody ToDo todo){
        return todoService.addToDo(todo);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable String id, @RequestBody ToDo todo){
        return todoService.updateStatus(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id){
        todoService.deleteTodo(id);
    }
}
