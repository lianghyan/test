package net.fsd.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

public class UserManager {
	public static void createUserForDelete(MockHttpServletRequestBuilder request) {

		request.param("userName", "ForDelete");
		request.param("password", enCodePass());
		request.param("firstName", "mengmeng");
		request.param("lastName", "zhang");
		request.param("contactNumber", "0411-8888");
		request.param("role", "user");
		request.param("linkedUrl", "xxxxx");
		request.param("active", "true");
		request.param("confirmedSignUp", "true");
		request.param("resetPassword", "true");
		request.param("resetPasswordDate", "2019/09/01");
		request.param("years_of_experience", "4");
	}

	public static void createUser(MockHttpServletRequestBuilder request) {

		request.param("userName", "usky");
		request.param("password", enCodePass());
		request.param("firstName", "mengmeng");
		request.param("lastName", "zhang");
		request.param("contactNumber", "0411-8888");
		request.param("role", "user");
		request.param("linkedUrl", "xxxxx");
		request.param("active", "true");
		request.param("confirmedSignUp", "true");
		request.param("resetPassword", "true");
		request.param("resetPasswordDate", "2019/09/01");
		request.param("years_of_experience", "4");
	}

	public static void createMentor(MockHttpServletRequestBuilder request) {

		request.param("userName", "msky");
		request.param("password", enCodePass());
		request.param("firstName", "meimei");
		request.param("lastName", "wang");
		request.param("contactNumber", "0411-8888");
		request.param("role", "mentor");
		request.param("linkedUrl", "xxxxx");
		request.param("active", "true");
		request.param("confirmedSignUp", "true");
		request.param("resetPassword", "true");
		request.param("resetPasswordDate", "2019/09/02");
		request.param("years_of_experience", "6");

	}

	public static void createAdmin(MockHttpServletRequestBuilder request) {
		Map map = new HashMap();
		request.param("userName", "admsky");
		request.param("password", enCodePass());
		request.param("firstName", "feifei");
		request.param("lastName", "li");
		request.param("contactNumber", "0411-8888");
		request.param("role", "admin");
		request.param("linkedUrl", "xxxxx");
		request.param("active", "true");
		request.param("confirmedSignUp", "true");
		request.param("resetPassword", "true");
		request.param("resetPasswordDate", "2019/09/03");
		request.param("years_of_experience", "8");

	}

	public static void createUser1(MockHttpServletRequestBuilder request) {
		Map map = new HashMap();
		request.param("userName", "ustar");
		request.param("password", enCodePass());
		request.param("firstName", "tiantian");
		request.param("lastName", "zhang");
		request.param("contactNumber", "0411-8888");
		request.param("role", "user");
		request.param("linkedUrl", "xxxxx");
		request.param("active", "true");
		request.param("confirmedSignUp", "true");
		request.param("resetPassword", "true");
		request.param("resetPasswordDate", "2019/09/04");
		request.param("years_of_experience", "10");

	}

	public static String enCodePass() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "111111";
		String enPwd = encoder.encode(rawPassword);
		return enPwd;
	}
}
