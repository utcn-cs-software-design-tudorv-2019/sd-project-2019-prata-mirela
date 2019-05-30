package com.example.demo.validator;

import com.example.demo.persistence.entity.User;

public class NameValidator implements Validator<User> {
	public int isValid(User t) {
		String name = t.getName().toLowerCase();
		if (name.length() <3 || name.length()>100)
			return 0;
		for (int i=0; i<name.length(); i++) {
			if ((name.charAt(i)<'a' || name.charAt(i)>'z')  && name.charAt(i)!=' ')
				return 0;
		}
		return 1;
	}	

}
