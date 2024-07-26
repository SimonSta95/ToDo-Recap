package org.spring.todorecap.service;

import org.junit.jupiter.api.Test;
import org.spring.todorecap.misc.ToDoStatus;
import org.spring.todorecap.model.ToDo;
import org.spring.todorecap.repo.ToDoRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ToDoServiceTest {

    private final ToDoRepo mockTodoRepo = mock(ToDoRepo.class);
    private final ToDoService todoService = new ToDoService(mockTodoRepo);

    //UNIT TESTS
    @Test
    void getAllToDos_Test(){
        List<ToDo> allToDos = List.of(
                new ToDo("1", ToDoStatus.OPEN, "TestToDo1"),
                new ToDo("2", ToDoStatus.IN_PROGRESS, "TestToDo2"),
                new ToDo("3", ToDoStatus.DONE, "TestToDo3")
        );

        List<ToDo> expectedToDos = List.of(
                new ToDo("1", ToDoStatus.OPEN, "TestToDo1"),
                new ToDo("2", ToDoStatus.IN_PROGRESS, "TestToDo2"),
                new ToDo("3", ToDoStatus.DONE, "TestToDo3")
        );

        when(mockTodoRepo.findAll()).thenReturn(allToDos);
        List<ToDo> actualToDos = todoService.getAllToDos();

        verify(mockTodoRepo).findAll();
        assertEquals(expectedToDos, actualToDos);
    }

    @Test
    void getToDoById_Test(){
        ToDo expectedToDo = new ToDo("1", ToDoStatus.OPEN, "TestToDo1");

        when(mockTodoRepo.findById("1")).thenReturn(Optional.of(expectedToDo));
        ToDo actualToDo = todoService.getToDoById("1");

        verify(mockTodoRepo).findById("1");
        assertEquals(expectedToDo, actualToDo);
    }

    @Test
    void addToDo_Test(){

        ToDo expectedToDo = new ToDo("4", ToDoStatus.OPEN, "TestToDo4");

        when(mockTodoRepo.save(expectedToDo)).thenReturn(expectedToDo);
        ToDo actualToDo = todoService.addToDo(expectedToDo);


        verify(mockTodoRepo).save(expectedToDo);
        assertEquals(expectedToDo, actualToDo);
    }

    @Test
    void updateToDo_Test(){

        ToDo expectedToDo = new ToDo("1", ToDoStatus.IN_PROGRESS, "TestToDo2");

        when(mockTodoRepo.save(expectedToDo)).thenReturn(expectedToDo);
        when(mockTodoRepo.findById("1")).thenReturn(Optional.of(expectedToDo));

        ToDo actualToDo = todoService.updateToDo("1",expectedToDo);

        verify(mockTodoRepo).findById("1");
        verify(mockTodoRepo).save(expectedToDo);
        assertEquals(expectedToDo, actualToDo);

    }

    @Test
    void deleteToDo_Test(){
        doNothing().when(mockTodoRepo).deleteById("1");
        todoService.deleteTodo("1");
        verify(mockTodoRepo).deleteById("1");
    }

}