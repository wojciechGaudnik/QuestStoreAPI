package com.kamprzewoj.queststore.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//@JsonProperty("name")
//	@JsonIgnore
//	@NotNull
//	@NotEmpty
//@Column(unique = true)  //todo <--- only help create data base, don't work with the same way as NotBlank

@Data
@Entity(name = "user_class_rest")
public class UserClassRest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@NotBlank(message = "name is mandatory")
	private String name;

	@NotBlank(message = "photoUrl is mandatory")
	private String photoUrl;

	public UserClassRest(String name, String photoUrl) {
		this.name = name;
		this.photoUrl = photoUrl;
	}

	public UserClassRest() {}
}
