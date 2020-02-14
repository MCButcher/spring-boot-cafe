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
import de.cegeka.springbootcafe.models.Menu;
import de.cegeka.springbootcafe.services.MenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class MenuController {
  private MenuService menuService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Adds a new menu")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Menu added successfully"), })
  public Menu add(@RequestBody Menu menu) {
    return menuService.insertOrUpdate(menu);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Updates an existing menu")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Menu updated successfully"), })
  public Menu update(@PathVariable("id") Long id, @RequestBody Menu menu) {
    return menuService.insertOrUpdate(menu);
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Deletes a menu")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Menu deleted successfully"), })
  public Menu delete(@PathVariable("id") Long id, @RequestBody Menu menu) {
    return menuService.delete(menu);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Gets the menu for the given id")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Get menu successfully"), })
  public Menu getById(@PathVariable("id") Long id) {
    return menuService.getById(id);
  }

  @GetMapping
  @ApiOperation(value = "Gets a list of all existing menu items")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Get all menus successfully"), })
  public List<Menu> getAll() {
    return menuService.getAll();
  }

  @GetMapping("/category")
  @ApiOperation(value = "Gets a list of all menu items of the category")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Menu added successfully"),
      @ApiResponse(code = 422, message = "Invalid category"), })
  public List<Menu> getByCategory(@RequestBody Category category) {
    return menuService.getByCategory(category);
  }

}