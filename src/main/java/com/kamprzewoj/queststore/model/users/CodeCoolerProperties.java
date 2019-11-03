package com.kamprzewoj.queststore.model.users;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(toBuilder = true)
@Audited
@Entity(name = "codecooler_properties")
public class CodeCoolerProperties implements Properties{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
}
