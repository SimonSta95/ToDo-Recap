package org.spring.todorecap.service;

import org.junit.jupiter.api.Test;
import org.spring.todorecap.misc.ToDoStatus;
import org.spring.todorecap.model.ToDo;
import org.spring.todorecap.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ToDoServiceIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ToDoRepo toDoRepo;

    //INTEGRATION TESTS

    @Test
    public void getAllToDos() throws Exception {

        ToDo test = new ToDo("1", ToDoStatus.OPEN, "Test1");
        ToDo test2 = new ToDo("2", ToDoStatus.OPEN, "Test2");

        toDoRepo.saveAll(List.of(test, test2));

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                    [
                                      {
                                            "id": "1",
                                            "status": "OPEN",
                                            "description": "Test1"
                                      },
                                      {
                                            "id": "2",
                                            "status": "OPEN",
                                            "description": "Test2"
                                      }
                                    ]
                                    """));
    }

    @Test
    public void getToDoById() throws Exception {

        ToDo test = new ToDo("1", ToDoStatus.OPEN, "Test1");
        toDoRepo.save(test);

        mockMvc.perform(get("/api/todo/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "1",
                            "status": "OPEN",
                            "description": "Test1"
                        }
                        """));
    }

    @Test
    public void addNewToDo() throws Exception {

        mockMvc.perform(post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "id": "1",
                                    "status": "OPEN",
                                    "description": "Test1"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "1",
                            "status": "OPEN",
                            "description": "Test1"
                        }
                        """))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void updateToDo() throws Exception {

        ToDo test = new ToDo("1", ToDoStatus.OPEN, "Test1");
        toDoRepo.save(test);

        mockMvc.perform(put("/api/todo/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "id": "1",
                                    "status": "IN_PROGRESS",
                                    "description": "Test1"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "1",
                            "status": "IN_PROGRESS",
                            "description": "Test1"
                        }
                        """));
    }

    @Test
    public void deleteToDo() throws Exception {

        toDoRepo.save(new ToDo("1", ToDoStatus.OPEN, "Test1"));

        mockMvc.perform(delete("/api/todo/1"))
                .andExpect(status().isOk());
    }
}