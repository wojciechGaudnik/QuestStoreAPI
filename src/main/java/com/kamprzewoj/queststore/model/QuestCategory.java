package com.kamprzewoj.queststore.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "quest_category")
public class QuestCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotNull(message = "name is mandatory <--- javax ")
	@NotEmpty(message = "name is mandatory <--- hibernate ")
	@NotBlank(message = "name is mandatory <--- javax ")
	private String name;


	public QuestCategory(String name) {
		this.name = name;
	}

	public QuestCategory() {}
}

