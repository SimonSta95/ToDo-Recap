package org.spring.todorecap.model;

import lombok.With;
import org.spring.todorecap.misc.ToDoStatus;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ToDo")
@With
public record ToDo(
        String id,
        ToDoStatus status,
        String description) {
}
