package com.kamprzewoj.queststore.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//@JsonProperty("name")
//	@JsonIgnore
//	@NotNull
//	@NotEmpty
//@Column(unique = true)  //todo <--- only help create data base, don't work with the same way as NotBlank

@Data
@Entity(name = "user_class")
public class UserClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@NotBlank(message = "name is mandatory")
	private String name;

	@NotEmpty(message = "photoUrl is mandatory <--- hibernate ")
	@NotBlank(message = "photoUrl is mandatory <--- javax ")
	private String photoUrl;

	public UserClass(String name, String photoUrl) {
		this.name = name;
		this.photoUrl = photoUrl;
	}

	public UserClass() {}
}
