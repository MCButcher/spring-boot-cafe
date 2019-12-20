package de.cegeka.springbootcafe.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import de.cegeka.springbootcafe.controllers.CategoryController;
import de.cegeka.springbootcafe.exceptions.UnknownCategoryException;
import de.cegeka.springbootcafe.models.Category;
import de.cegeka.springbootcafe.services.CategoryService;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper mapper;

  @MockBean
  CategoryService service;

  @Test
  void testAdd() throws JsonProcessingException, Exception {
    Category category = new Category(1L, "category");

    when(service.insertOrUpdate(category)).thenReturn(category);

    MvcResult result = mockMvc
        .perform(post("/category").content(mapper.writeValueAsString(category)).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

    String resultAsString = result.getResponse().getContentAsString();
    assertThat(resultAsString).isNotEmpty().contains("1", "category");
  }

  @Test
  void testAddWithError() throws JsonProcessingException, Exception {
    Category category = new Category(1L, "category");

    when(service.insertOrUpdate(category)).thenThrow(new UnknownCategoryException("unknown"));

    MvcResult result = mockMvc
        .perform(post("/category").content(mapper.writeValueAsString(category)).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnprocessableEntity()).andReturn();

    String resultAsString = result.getResponse().getContentAsString();
    assertThat(resultAsString).isNotEmpty().contains("UNPROCESSABLE_ENTITY", "unknown");
  }

  @Test
  void testGetById() throws JsonProcessingException, Exception {
    Category category = new Category(1L, "category");

    when(service.getById(1L)).thenReturn(category);

    MvcResult result = mockMvc.perform(get("/category/1")).andExpect(status().isOk()).andReturn();

    String resultAsString = result.getResponse().getContentAsString();
    assertThat(resultAsString).isNotEmpty().contains("1", "category");
  }

}