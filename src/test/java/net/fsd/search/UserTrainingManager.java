package net.fsd.search;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.fsd.entity.Training;

public class UserTrainingManager {
	public static void createTrainingHibernate(MockHttpServletRequestBuilder request) {
		request.param("userId", "1");
		request.param("trainingId", "1");
	}

	public static void createTrainingMySQL(MockHttpServletRequestBuilder request) {
		request.param("userId", "2");
		request.param("trainingId", "3");
	}

	public static void createTrainingSpring(MockHttpServletRequestBuilder request) {
		request.param("userId", "2");
		request.param("trainingId", "1");
	}

	public static void createForUpdate(MockHttpServletRequestBuilder request) {
		request.param("userId", "2");
		request.param("trainingId", "3");

	}

	public static void createForDelete(MockHttpServletRequestBuilder request) {
		request.param("userId", "2");
		request.param("trainingId", "4");

	}
}
