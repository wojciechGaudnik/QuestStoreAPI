package com.kamprzewoj.queststore.__temporary.__model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "level")
public class UserLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(unique = true)
	@NotEmpty(message = "name is mandatory")
	private String name;

	@Column(unique = true)
	@NotNull(message = "value is mandatory")
	private int value;

	public UserLevel(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public UserLevel() {}
}
