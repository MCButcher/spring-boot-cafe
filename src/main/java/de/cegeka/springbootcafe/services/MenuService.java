package de.cegeka.springbootcafe.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import de.cegeka.springbootcafe.exceptions.UnknownCategoryException;
import de.cegeka.springbootcafe.models.Category;
import de.cegeka.springbootcafe.models.Menu;
import de.cegeka.springbootcafe.repositories.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MenuService {
   private MenuRepository repository;

   public Menu insertOrUpdate(Menu menu) {
      return repository.save(menu);
   }

   public Menu delete(Menu menu) {
      return menu;
   }

   public Menu getById(Long id) {
      return repository.findById(id).orElse(new Menu());
   }

   public List<Menu> getAll() {
      List<Menu> list = new ArrayList<>();
      repository.findAll().forEach(list::add);
      return list;
   }

   public List<Menu> getByCategory(Category category) {
      if (category == null || StringUtils.isEmpty(category.getName())) {
         throw new UnknownCategoryException("category is null");
      }
      return repository.findByCategory(category);
   }

   @PostConstruct
   public void initDatabase() {
      List<Menu> menuList = new ArrayList<>();
      menuList.add(new Menu(null, "Cappuccino", 2.80, new Category(1L, "Drinks")));
      menuList.add(new Menu(null, "Cafe Crema", 2.60, new Category(1L, "Drinks")));
      menuList.add(new Menu(null, "Cheese Cake", 2.30, new Category(2L, "Food")));
      Iterable<Menu> initList = repository.saveAll(menuList);
      log.info("Database initialized with Menus: {}", initList);
   }
}
