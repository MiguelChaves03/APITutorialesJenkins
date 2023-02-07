package com.ejercicio.tutorials.repository;

import com.ejercicio.tutorials.model.TutorialsDTO;
import org.springframework.stereotype.*;
import org.springframework.data.mongodb.repository.*;
import com.ejercicio.tutorials.model.domain.*;

import java.util.List;

@Repository
public interface TutorialsRepository extends MongoRepository<Tutorials, String> {

    List<Tutorials> findByTitleContaining(String title);

}
