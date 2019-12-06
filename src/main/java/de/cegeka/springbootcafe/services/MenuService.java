package de.cegeka.springbootcafe.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.cegeka.springbootcafe.models.Category;
import de.cegeka.springbootcafe.models.Menu;

@Service
public class MenuService {
   public Menu add (Menu menu) {
      menu.setId(1L);
      return menu;
   }

   public Menu update (Menu menu) {
      return menu;
   }

   public Menu delete (Menu menu) {
      return menu;
   }

   public Menu getById (Long id) {
      return Menu.builder().id(id).item("Sparkling Water").price(1.50).category(new Category(1L, "Drinks")).build();
   }

   public List<Menu> getAll () {
      return Arrays.asList(Menu.builder().id(1L).item("Sparkling Water").price(1.50).category(new Category(1L, "Drinks")).build());
   }

   public List<Menu> getByCategory (Category category) {
      return Arrays.asList(Menu.builder().id(1L).item("Sparkling Water").price(1.50).category(category).build());
   }
}
