package de.cegeka.springbootcafe.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Menu {
   private Long id;
   private String item;
   private Double price;
   private Category category;
}
