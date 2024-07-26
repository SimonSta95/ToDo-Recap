package org.spring.todorecap.service;

import org.junit.jupiter.api.Test;
import org.spring.todorecap.misc.ToDoStatus;
import org.spring.todorecap.model.ToDo;
import org.spring.todorecap.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
//class ToDoServiceIntegrationTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ToDoRepo toDoRepo;
//
//    @Test
//    public void getAllToDos() throws Exception {
//
//        ToDo test = new ToDo("1", ToDoStatus.OPEN, "Test1");
//        ToDo test2 = new ToDo("2", ToDoStatus.OPEN, "Test2");
//
//        toDoRepo.saveAll(List.of(test, test2));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("""
//                                    [
//                                      {
//                                            "id": "1",
//                                            "status": "OPEN",
//                                            "description": "Test1"
//                                      },
//                                      {
//                                            "id": "2",
//                                            "status": "OPEN",
//                                            "description": "Test2"
//                                      }
//                                    ]
//                                    """));
//
//    }
//}