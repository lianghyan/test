package net.fsd.skill;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import net.fsd.main.BaseTestController;

public class SkillManager {
	
	public static void createForDelete(MockHttpServletRequestBuilder request) {
		request.param("name", "For delete")
		.param("prerequisites", "for test")
		.param("toc", "this is a test");
	}
	
	public static void createForUpdate(MockHttpServletRequestBuilder request) {
		request.param("name", "For update")
		.param("prerequisites", "for update")
		.param("toc", "this is a update");
	}
	
	public static void createMYSQL(MockHttpServletRequestBuilder request) {
		request.param("name", "MYSQL")
		.param("prerequisites", "SQL sentence")
		.param("toc", "this is a test");
	}
	public static void createSpring(MockHttpServletRequestBuilder request) {
		request.param("name", "Spring")
		.param("prerequisites", "Spring, web")
		.param("toc", "this is a test");
	}
	
	public static void createHibernate(MockHttpServletRequestBuilder request) {
		request.param("name", "Hibernate")
		.param("prerequisites", "database, xml")
		.param("toc", "this is a test");
	}
}
