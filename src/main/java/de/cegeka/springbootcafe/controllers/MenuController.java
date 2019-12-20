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
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class MenuController {
  private MenuService menuService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public Menu add(@RequestBody Menu menu) {
    return menuService.insertOrUpdate(menu);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Menu update(@PathVariable("id") Long id, @RequestBody Menu menu) {
    return menuService.insertOrUpdate(menu);
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Menu delete(@PathVariable("id") Long id, @RequestBody Menu menu) {
    return menuService.delete(menu);
  }

  @GetMapping("/{id}")
  public Menu getById(@PathVariable("id") Long id) {
    return menuService.getById(id);
  }

  @GetMapping
  public List<Menu> getAll() {
    return menuService.getAll();
  }

  @GetMapping("/category")
  public List<Menu> getByCategory(@RequestBody Category category) {
    return menuService.getByCategory(category);
  }

}