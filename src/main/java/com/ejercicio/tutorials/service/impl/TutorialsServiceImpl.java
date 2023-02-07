package com.ejercicio.tutorials.service.impl;

import org.springframework.stereotype.*;
import lombok.*;
import com.ejercicio.tutorials.service.*;
import org.springframework.beans.factory.annotation.*;
import com.ejercicio.tutorials.repository.*;
import com.ejercicio.tutorials.util.*;
import java.util.*;
import com.ejercicio.tutorials.model.domain.*;
import com.ejercicio.tutorials.model.*;

@Service
@RequiredArgsConstructor
public class TutorialsServiceImpl implements TutorialsService {

	@Autowired
	private final TutorialsRepository tutorialsRepository;

	@Autowired
	private final TutorialsMapper tutorialsMapper;

	@Override
	public List<TutorialsDTO> getAllTutorials() {

		return tutorialsMapper.fromListToDTO(tutorialsRepository.findAll());

	}

	@Override
	public TutorialsDTO getTutorialById(String id) {

		return tutorialsMapper.fromEntityToDTO(tutorialsRepository.findById(id));

	}

	@Override
	public List<TutorialsDTO> getTutorialByTitle(String title) {

		return tutorialsMapper.fromListToDTO(tutorialsRepository.findByTitleContaining(title));

	}

	@Override
	public List<TutorialsDTO> findByPublished() {

		List<TutorialsDTO> tutorialsDTO = new ArrayList<>();

		List<Tutorials> tutorials = tutorialsRepository.findAll();

		for (Tutorials tutorial : tutorials) {

			if (tutorial.isPublished()) {

				tutorialsDTO.add(tutorialsMapper.fromEntityToDTO(tutorial));

			}

		}

		return tutorialsDTO;

	}

	@Override
	public TutorialsDTO createTutorial(Tutorials tutorials) {

		return tutorialsMapper.fromEntityToDTO(tutorialsRepository.save(tutorials));

	}

	@Override
	public TutorialsDTO updateTutorial(Tutorials tutorials, String id) {

		if (tutorialsRepository.existsById(id)) {

			return tutorialsMapper.fromEntityToDTO(tutorialsRepository.save(tutorials));

		} else {

			return tutorialsMapper.fromEntityToDTO(tutorials);

		}

	}

	@Override
	public void deleteTutorial(String id) {

		if (tutorialsRepository.existsById(id)) {

			tutorialsRepository.deleteById(id);

		}

	}

	@Override
	public void deleteAllTutorials() {

		List<Tutorials> tutorials = tutorialsRepository.findAll();

		if (!tutorials.isEmpty()) {

			tutorialsRepository.deleteAll();

		}

	}

}
