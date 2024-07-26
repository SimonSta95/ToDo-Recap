package org.spring.todorecap.service;

import org.spring.todorecap.model.ToDo;
import org.spring.todorecap.repo.ToDoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepo todorepo;

    public ToDoService(ToDoRepo todorepo) {
        this.todorepo = todorepo;
    }

    public List<ToDo> getAllToDos() {

        return todorepo.findAll();
    }

    public ToDo getToDoById(String id) {

        return todorepo.findById(id).orElseThrow();
    }

    public ToDo addToDo(ToDo todo) {

        return todorepo.save(todo);
    }

    public ToDo updateToDo(String id, ToDo toDo) {
        todorepo.save(toDo);

        return todorepo.findById(id).orElseThrow();

    }

    public void deleteTodo(String id) {
        todorepo.deleteById(id);
    }
}
