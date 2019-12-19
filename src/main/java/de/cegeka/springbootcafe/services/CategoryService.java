package de.cegeka.springbootcafe.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.cegeka.springbootcafe.models.Category;
import de.cegeka.springbootcafe.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryService {
   private CategoryRepository repository;

   public Category insertOrUpdate(final Category category) {
      return repository.save(category);
   }

   public Category delete(final Category category) {
      repository.delete(category);
      return category;
   }

   public Category getById(Long id) {
      return repository.findById(id).orElse(new Category());
   }

   public List<Category> getAll() {
      List<Category> list = new ArrayList<>();
      repository.findAll().forEach(list::add);
      return list;
   }

   @PostConstruct
   public void initDatabase() {
      List<Category> categoryList = new ArrayList<>();
      categoryList.add(new Category(null, "Drinks"));
      categoryList.add(new Category(null, "Food"));
      Iterable<Category> initList = repository.saveAll(categoryList);
      log.info("Database initialized with Categories: {}", initList);
   }
}
