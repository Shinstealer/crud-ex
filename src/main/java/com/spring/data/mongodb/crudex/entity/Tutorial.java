package com.spring.data.mongodb.crudex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document("tutorials")
@Getter
@Setter
public class Tutorial {
  @Id
  private String id;

  private String title;
  private String description;
  private boolean published;

  public Tutorial() {
  }

  public Tutorial(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }
}
