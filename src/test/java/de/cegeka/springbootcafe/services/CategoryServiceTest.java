package de.cegeka.springbootcafe.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.cegeka.springbootcafe.exceptions.UnknownCategoryException;
import de.cegeka.springbootcafe.models.Category;
import de.cegeka.springbootcafe.repositories.CategoryRepository;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
  CategoryService serviceUnderTest;

  @Mock
  CategoryRepository repository;

  @BeforeEach
  void beforeEach() {
    serviceUnderTest = new CategoryService(repository);
  }

  @Test
  void testInsertOrUpdate() {
    Category expectedCategory = new Category(1L, "category");
    Category entity = new Category();

    when(repository.save(entity)).thenReturn(expectedCategory);

    Category category = serviceUnderTest.insertOrUpdate(entity);

    assertThat(category).isNotNull().isEqualTo(expectedCategory);
  }

  @Test
  void testInsertOrUpdateThrowsException() {
    Category entity = new Category();

    when(repository.save(entity)).thenThrow(new UnknownCategoryException("unknown"));

    assertThrows(UnknownCategoryException.class, () -> serviceUnderTest.insertOrUpdate(entity)).getMessage()
        .contains("unknown");
  }

  @Test
  void testGetByIdValid() {
    Category expectedCategory = new Category(1L, "category");

    when(repository.findById(1L)).thenReturn(Optional.of(expectedCategory));

    Category category = serviceUnderTest.getById(1L);

    assertThat(category).isNotNull().isEqualTo(expectedCategory);
  }

  @Test
  void testGetByIdInvalid() {
    Category expectedCategory = new Category();

    when(repository.findById(1L)).thenReturn(Optional.ofNullable(null));

    Category category = serviceUnderTest.getById(1L);

    assertThat(category).isNotNull().isEqualTo(expectedCategory);
  }

  @Test
  void testGetAll() {
    Iterable<Category> expectedList = Arrays.asList(new Category(1L, "c1"), new Category(2L, "c2"));
    when(repository.findAll()).thenReturn(expectedList);

    List<Category> categoryList = serviceUnderTest.getAll();

    assertThat(categoryList).isNotNull().isNotEmpty().hasSize(2).isEqualTo(expectedList);
  }

}