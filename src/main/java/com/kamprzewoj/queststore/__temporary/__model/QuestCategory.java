//package com.kamprzewoj.queststore.__temporary.__model;
//
//import lombok.Data;
//import org.hibernate.validator.constraints.NotEmpty;
//import javax.persistence.*;
//
//@Data
//@Entity(name = "quest_category")
//public class QuestCategory {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long Id;
//
//	@Column(unique = true)
//	@NotEmpty(message = "name is mandatory")
//	private String name;
//
//	public QuestCategory(String name) {
//		this.name = name;
//	}
//
//	public QuestCategory() {}
//}
//
