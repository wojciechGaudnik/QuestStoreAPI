//package com.kamprzewoj.queststore.model.persons;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.kamprzewoj.queststore.model.common.UserClass;
//import lombok.*;
//import org.hibernate.envers.Audited;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor(access = AccessLevel.PACKAGE)
//@NoArgsConstructor(access = AccessLevel.PACKAGE)
//@Builder(toBuilder = true)
//@Audited
//@Entity(name = "mentors")
//public class Mentor implements Person{
//
//	@javax.persistence.Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long Id;
//
//	@JsonIgnore
//	private final String role = "mentor";
//
//	@NotBlank(message = "firstName is mandatory")
//	@Size(min = 3, max = 100, message = "length out of range ")
//	private String firstName;
//
//	@NotBlank(message = "last is mandatory")
//	@Size(min = 3, max = 100, message = "length out of range ")
//	private String lastName;
//
//	@Column(unique = true)
//	@NotBlank(message = "email is mandatory")
//	@Size(min = 3, max = 100, message = "length out of range ")
//	@Email(message="Please provide a valid email address")
//	private String email;
//
//	@Column(unique = true)
//	@NotBlank(message = "nick is mandatory")
//	@Size(min = 3, max = 50, message = "length out of range ")
//	private String nick;
//
//	@NotBlank(message = "password is mandatory")
//	private String password;  //todo <--- how save password
//
//	@Column(unique = true)
//	@Size(min = 3, max = 100, message = "length out of range ")
//	private String photoUrl;
//
//	@ManyToMany(
//			targetEntity = UserClass.class)
//	@JoinTable(
//			name = "join_userclasses_mentors",
//			joinColumns = {@JoinColumn(name = "mentor_id")},
//			inverseJoinColumns = {@JoinColumn(name = "user_class_id")})
//	private List<UserClass> userClasses;
//}
//
//
