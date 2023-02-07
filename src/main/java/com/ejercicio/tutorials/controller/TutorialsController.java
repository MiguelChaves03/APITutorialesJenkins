package com.ejercicio.tutorials.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.ejercicio.tutorials.service.*;
import org.springframework.http.*;
import com.ejercicio.tutorials.model.*;
import com.ejercicio.tutorials.model.domain.*;

import java.util.List;

@CrossOrigin
@RestController
public class TutorialsController implements TutorialsApi {

	@Autowired
	private TutorialsService tutorialsService;

	@Override
	public ResponseEntity<?> getAllTutorials() {

		if (tutorialsService.getAllTutorials().isEmpty()) {

			return ResponseEntity.notFound().build();

		} else {

			return ResponseEntity.ok(tutorialsService.getAllTutorials());

		}

	}

	@Override
	public ResponseEntity<?> getTutorialById(@PathVariable String id) {

		TutorialsDTO tutorialsDTO = tutorialsService.getTutorialById(id);

		if (tutorialsDTO == null) {

			return ResponseEntity.notFound().build();

		} else {

			return ResponseEntity.ok(tutorialsService.getTutorialById(id));

		}

	}

	@Override
	public ResponseEntity<?> getTutorialByTitle(@PathVariable String title) {

		List<TutorialsDTO> tutorialsDTO = tutorialsService.getTutorialByTitle(title);

		if ( tutorialsDTO == null) {

			return ResponseEntity.notFound().build();

		} else {

			return ResponseEntity.ok(tutorialsService.getTutorialByTitle(title));

		}

	}

	@Override
	public ResponseEntity<?> findByPublished() {

		if (tutorialsService.findByPublished().isEmpty()) {

			return ResponseEntity.notFound().build();

		} else {

			return ResponseEntity.ok(tutorialsService.findByPublished());

		}

	}

	@Override
	public ResponseEntity<?> createTutorial(@RequestBody Tutorials tutorials) {

		if (tutorials == null) {

			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(tutorialsService.createTutorial(tutorials));

		} else {

			return ResponseEntity.status(HttpStatus.CREATED).body(tutorialsService.createTutorial(tutorials));

		}

	}

	@Override
	public ResponseEntity<?> updateTutorial(Tutorials tutorials, String id) {

		if (tutorials == null) {

			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(tutorialsService.updateTutorial(tutorials, id));

		} else {

			return ResponseEntity.ok(tutorialsService.createTutorial(tutorials));

		}

	}

	@Override
	public ResponseEntity<?> deleteTutorial(@PathVariable String id) {

		if (tutorialsService.getTutorialById(id) == null) {

			return ResponseEntity.notFound().build();

		} else {

			tutorialsService.deleteTutorial(id);

			return ResponseEntity.noContent().build();

		}

	}

	@Override
	public ResponseEntity<?> deleteAllTutorials() {

		if (tutorialsService.getAllTutorials() == null) {

			return ResponseEntity.notFound().build();

		} else {

			tutorialsService.deleteAllTutorials();

			return ResponseEntity.noContent().build();

		}

	}

}
