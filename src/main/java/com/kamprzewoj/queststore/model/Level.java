package com.kamprzewoj.queststore.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//@JsonProperty("name")
//	@JsonIgnore
//	@NotNull
//	@NotEmpty
//@Column(unique = true)  //todo <--- only help create data base, don't work with the same way as NotBlank

@Data
@Entity(name = "level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotNull(message = "name is mandatory <--- javax ")
	@NotEmpty(message = "name is mandatory <--- hibernate ")
	@NotBlank(message = "name is mandatory <--- javax ")
	private String name;

	@NotNull(message = "value is mandatory <--- javax ")
	private int value;

	public Level(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public Level() {}
}
