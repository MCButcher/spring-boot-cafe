package de.cegeka.springbootcafe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.cegeka.springbootcafe.models.Category;
import de.cegeka.springbootcafe.models.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
    public List<Menu> findByCategory(Category category);
}