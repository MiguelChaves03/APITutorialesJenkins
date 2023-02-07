package com.ejercicio.tutorials.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.ejercicio.tutorials.model.domain.*;

@RequestMapping
public interface TutorialsApi {

	@GetMapping("/tutorials")
	public ResponseEntity<?> getAllTutorials();

	@GetMapping("/tutorials/id/{id}")
	public ResponseEntity<?> getTutorialById(@PathVariable String id);

	@GetMapping("/tutorials/title/{title}")
	public ResponseEntity<?> getTutorialByTitle(@PathVariable String title);

	@GetMapping("/published")
	public ResponseEntity<?> findByPublished();

	@PostMapping("/tutorials")
	public ResponseEntity<?> createTutorial(@RequestBody Tutorials tutorials);

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<?> updateTutorial(@RequestBody Tutorials tutorials, @PathVariable String id);

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<?> deleteTutorial(@PathVariable String id);

	@DeleteMapping("/tutorials")
	public ResponseEntity<?> deleteAllTutorials();

}
