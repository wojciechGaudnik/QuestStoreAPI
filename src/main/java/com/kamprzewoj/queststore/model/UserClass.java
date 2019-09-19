package com.kamprzewoj.queststore.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;

@Data
@Entity(name = "user_class")
public class UserClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(unique = true)
	@NotEmpty(message = "name is mandatory")
	private String name;

	@NotEmpty(message = "name is mandatory")
	private String photoUrl;

	public UserClass(String name, String photoUrl) {
		this.name = name;
		this.photoUrl = photoUrl;
	}

	public UserClass() {}
}
