package de.cegeka.springbootcafe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
@ApiModel(description = "Model for the menu")
public class Menu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "Generated ID")
  private Long id;

  @Length(max = 100)
  @NotNull
  @ApiModelProperty(value = "Name of the menu item", example = "Coffee")
  private String item;

  @Positive
  @ApiModelProperty(value = "Price of the menu item", example = "2.50")
  private Double price;

  @OneToOne
  @NotNull
  @ApiModelProperty(value = "Name of the category the menu item is belonging to", example = "Drinks")
  private Category category;
}
