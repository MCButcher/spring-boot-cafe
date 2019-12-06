package de.cegeka.springbootcafe.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.cegeka.springbootcafe.models.Category;

@Service
public class CategoryService {
   public Category add (Category category) {
      category.setId(1L);
      return category;
   }

   public Category update (Category category) {
      return category;
   }

   public Category delete (Category category) {
      return category;
   }

   public Category getById (Long id) {
      return new Category(id, "random");
   }

   public List<Category> getAll () {
      return Arrays.asList(new Category(1L, "random"));
   }

}
