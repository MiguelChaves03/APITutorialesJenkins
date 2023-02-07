package com.ejercicio.tutorials.service;

import java.util.*;
import com.ejercicio.tutorials.model.*;
import com.ejercicio.tutorials.model.domain.*;

public interface TutorialsService {

	public List<TutorialsDTO> getAllTutorials();

	public TutorialsDTO getTutorialById(String id);

	public List<TutorialsDTO> getTutorialByTitle(String title);

	public List<TutorialsDTO> findByPublished();

	public TutorialsDTO createTutorial(Tutorials tutorials);

	public TutorialsDTO updateTutorial(Tutorials tutorials, String id);

	public void deleteTutorial(String id);

	public void deleteAllTutorials();

}
