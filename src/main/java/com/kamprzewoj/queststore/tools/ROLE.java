package com.kamprzewoj.queststore.tools;

import java.util.ArrayList;
import java.util.List;

public interface ROLE {

	String CREEPY = "creepy";
	String MENTOR = "mentor";
	String USER = "user";

	default List<String> getAllRoles(){
		return new ArrayList<>() {{
			add("[ROLE_" + CREEPY + "]");
			add("[ROLE_" + MENTOR + "]");
			add("[ROLE_" + USER + "]");
		}};
	}
}
