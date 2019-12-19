package de.cegeka.springbootcafe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.cegeka.springbootcafe.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}