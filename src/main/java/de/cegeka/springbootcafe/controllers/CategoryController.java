package de.cegeka.springbootcafe.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.cegeka.springbootcafe.models.Category;
import de.cegeka.springbootcafe.services.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
  private CategoryService categoryService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Adds a new category")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Category added successfully"), })
  public Category add(@RequestBody Category category) {
    return categoryService.insertOrUpdate(category);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Updates an existing category")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Category updated successfully"), })
  public Category update(@PathVariable("id") Long id, @RequestBody Category category) {
    return categoryService.insertOrUpdate(category);
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Deletes a category")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Category deleted successfully"), })
  public Category delete(@PathVariable("id") Long id, @RequestBody Category category) {
    return categoryService.delete(category);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Gets the category for the given id")
  public Category getById(@PathVariable("id") Long id) {
    return categoryService.getById(id);
  }

  @GetMapping
  @ApiOperation(value = "Gets a list of all existing categories")
  public List<Category> getAll() {
    return categoryService.getAll();
  }
}
