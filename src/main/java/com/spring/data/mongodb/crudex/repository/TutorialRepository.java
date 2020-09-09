package com.spring.data.mongodb.crudex.repository;

import java.util.List;
import com.spring.data.mongodb.crudex.entity.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
  List<Tutorial> findByTitleContaining(String title);

  List<Tutorial> findByPublished(boolean published);
}
