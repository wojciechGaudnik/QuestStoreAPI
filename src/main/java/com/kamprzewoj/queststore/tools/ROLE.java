package com.kamprzewoj.queststore.tools;

import java.util.ArrayList;
import java.util.List;

public interface ROLE {

	String CREEPY = "creepy";
	String MENTOR = "mentor";
	String USER = "user";

	default List<String> getAll(){
		return new ArrayList<>() {{
			add(CREEPY);
			add(MENTOR);
			add(USER);
		}};
	}
}
