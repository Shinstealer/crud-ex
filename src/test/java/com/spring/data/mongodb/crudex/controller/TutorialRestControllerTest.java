package com.spring.data.mongodb.crudex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import com.spring.data.mongodb.crudex.entity.Tutorial;
import com.spring.data.mongodb.crudex.repository.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TutorialRestControllerTest {

  @Autowired
  TutorialRepository repository;

  @Autowired
  TutorialRestController controller;

  // @Autowired
  // RestTemplate restTemplate;

  @Autowired
  private MockMvc mockMvc;

  private final static String reqUrl = "http://localhost:8081/api/v1";

  @Test
  public void getAllTutorials() {
    List<Tutorial> tutorials = repository.findAll();
    assertEquals(tutorials.size(), 10);

    try {
      this.mockMvc.perform(get(reqUrl + "/tutorials")).andDo(MockMvcResultHandlers.print())
          .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

}
