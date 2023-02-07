package com.ejercicio.tutorials.util;

import org.springframework.stereotype.*;
import lombok.*;
import org.modelmapper.*;
import com.ejercicio.tutorials.model.*;
import com.ejercicio.tutorials.model.domain.*;
import java.util.*;

@Component
@RequiredArgsConstructor
public class TutorialsMapper {

	private final ModelMapper modelMapper;

	public TutorialsDTO fromEntityToDTO(Tutorials tutorials) {

		return modelMapper.map(tutorials, TutorialsDTO.class);

	}

	public TutorialsDTO fromEntityToDTO(Optional<Tutorials> tutorials) {

		return modelMapper.map(tutorials, TutorialsDTO.class);

	}

	public List<TutorialsDTO> fromListToDTO(List<Tutorials> tutorials) {

		List<TutorialsDTO> tutorialsDTO = new ArrayList<>();

		for (Tutorials tutorial : tutorials) {

			tutorialsDTO.add(modelMapper.map(tutorial, TutorialsDTO.class));

		}

		return tutorialsDTO;

	}

	public Tutorials fromDTOToEntity(TutorialsDTO tutorials) {

		return modelMapper.map(tutorials, Tutorials.class);

	}

}
