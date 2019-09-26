package com.kamprzewoj.queststore.__temporary.__model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;

@Data
@Entity(name = "item_category")
public class ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(unique = true)
	@NotEmpty(message = "name is mandatory")
	private String name;

	public ItemCategory(String name) {
		this.name = name;
	}

	public ItemCategory() {}
}


