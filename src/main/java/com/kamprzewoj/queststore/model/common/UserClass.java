package com.kamprzewoj.queststore.model.common;

import com.kamprzewoj.queststore.model.persons.Mentor;
import com.kamprzewoj.queststore.model.persons.User;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(toBuilder = true)
@Audited
@Entity(name = "user_classes")
public class UserClass {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(unique = true)
	@NotBlank(message = "name is mandatory")
	@Size(min = 3, max = 100, message = "length out of range ")
	private String name;

	@Column(unique = true)
	@NotBlank(message = "photoUrl is mandatory")
	@Size(min = 3, max = 100, message = "length out of range ")
	private String photoUrl;


	@ManyToMany(
			targetEntity= Mentor.class)
	@JoinTable(
			uniqueConstraints = {@UniqueConstraint(columnNames = {"mentor_id", "user_class_id"})},
			name= "join_userclasses_mentors",
			joinColumns = {@JoinColumn(name = "user_class_id")},
			inverseJoinColumns = {@JoinColumn(name = "mentor_id")})
	private List<Mentor> mentors;

	@OneToMany(
			mappedBy = "userClass",
			targetEntity = User.class)
	private List<User> userList;
}
