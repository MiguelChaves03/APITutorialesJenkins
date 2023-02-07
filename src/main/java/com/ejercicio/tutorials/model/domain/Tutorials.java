package com.ejercicio.tutorials.model.domain;

import org.springframework.data.mongodb.core.mapping.*;
import lombok.*;
import org.springframework.data.annotation.*;

@Document(collection = "tutorials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tutorials {

	@Id
	private String id;

	private String title;

	private String description;

	private boolean published;

}
