package com.kamprzewoj.queststore.model.users;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(toBuilder = true)
@Audited
@Entity(name = "mentor_properties")
public class MentorProperties implements Properties{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
}
