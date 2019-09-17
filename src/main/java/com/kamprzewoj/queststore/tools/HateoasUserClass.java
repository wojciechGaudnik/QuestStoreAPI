package com.kamprzewoj.queststore.tools;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Getter
public class HateoasUserClass extends ResourceSupport {

	private final UserClass userClass;

	public HateoasUserClass(final UserClass userClass) {
		this.userClass = userClass;
		final long id = userClass.getId();
		add(linkTo(UserClassService.class).withRel("UserClass"));
	}
}