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
import de.cegeka.springbootcafe.models.Menu;
import de.cegeka.springbootcafe.repositories.MenuRepository;

@ExtendWith(MockitoExtension.class)
class MenuServiceTest {
  MenuService serviceUnderTest;

  @Mock
  MenuRepository repository;

  @BeforeEach
  void beforeEach() {
    serviceUnderTest = new MenuService(repository);
  }

  @Test
  void testInsertOrUpdate() {
    Menu expectedMenu = new Menu(1L, "Coffee", 2.50, new Category(1L, "Drinks"));
    Menu entity = new Menu(null, "Coffee", 2.50, new Category(1L, "Drinks"));

    when(repository.save(entity)).thenReturn(expectedMenu);

    Menu menu = serviceUnderTest.insertOrUpdate(entity);

    assertThat(menu).isNotNull().isEqualTo(expectedMenu);
  }

  @Test
  void testInsertOrUpdateThrowsException() {
    Menu entity = new Menu();

    when(repository.save(entity)).thenThrow(new UnknownCategoryException("unknown"));

    assertThrows(UnknownCategoryException.class, () -> serviceUnderTest.insertOrUpdate(entity)).getMessage()
        .contains("unknown");
  }

  @Test
  void testGetByIdValid() {
    Menu expectedMenu = new Menu(1L, "Coffee", 2.50, new Category(1L, "Drinks"));

    when(repository.findById(1L)).thenReturn(Optional.of(expectedMenu));

    Menu menu = serviceUnderTest.getById(1L);

    assertThat(menu).isNotNull().isEqualTo(expectedMenu);
  }

  @Test
  void testGetByIdInvalid() {
    Menu expectedMenu = new Menu();

    when(repository.findById(1L)).thenReturn(Optional.ofNullable(null));

    Menu menu = serviceUnderTest.getById(1L);

    assertThat(menu).isNotNull().isEqualTo(expectedMenu);
  }

  @Test
  void testGetAll() {
    Iterable<Menu> expectedList = Arrays.asList(new Menu(1L, "Coffee", 2.50, new Category(1L, "c1")),
        new Menu(2L, "Cake", 2.30, new Category(2L, "c2")));
    when(repository.findAll()).thenReturn(expectedList);

    List<Menu> menuList = serviceUnderTest.getAll();

    assertThat(menuList).isNotNull().isNotEmpty().hasSize(2).isEqualTo(expectedList);
  }

  @Test
  void testGetByCategory() {
    Category category = new Category(1L, "Drinks");
    List<Menu> expectedList = Arrays.asList(new Menu(1L, "Coffee", 2.50, category),
        new Menu(2L, "Cake", 2.30, new Category(2L, "c2")));

    when(repository.findByCategory(category)).thenReturn(expectedList);

    List<Menu> menuList = serviceUnderTest.getByCategory(category);

    assertThat(menuList).isNotNull().isNotEmpty().hasSize(2).isEqualTo(expectedList);
  }

  @Test
  void testGetByCategoryThrowsException() {
    assertThrows(UnknownCategoryException.class, () -> serviceUnderTest.getByCategory(new Category())).getMessage()
        .contains("unknown");
  }

}