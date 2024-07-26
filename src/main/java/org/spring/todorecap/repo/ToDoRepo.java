package org.spring.todorecap.repo;

import org.spring.todorecap.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ToDoRepo extends MongoRepository<ToDo, String> {
}
