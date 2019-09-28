//package com.kamprzewoj.queststore.__temporary.__model;
//
//import lombok.Data;
//import org.hibernate.validator.constraints.NotEmpty;
//import javax.persistence.*;
//
////@Documented
//@Data
//@Entity(name = "item_card")
//public class ItemCard {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long Id;
//
//	@Column(unique = true)
//	@NotEmpty(message = "name is mandatory")
//	private String name;
//
//
////	private int value;
////
////	@Column(unique = true)
////	@NotEmpty(message = "photoUrl is mandatory")
////	private String photoUrl;
////
////	private int requiredLevel;
////
//
////	private String description;
//
//	@OneToOne
//	private ItemCategory itemCategory;
//
//	public ItemCard(String name, ItemCategory itemCategory) {
//		this.name = name;
//		this.itemCategory = itemCategory;
//	}
//
//	public ItemCard() {
//	}
//}
