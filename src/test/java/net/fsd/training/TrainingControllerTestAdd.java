package net.fsd.training;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.alibaba.fastjson.JSONObject;

import net.fsd.main.AppConfig;
import net.fsd.main.BaseTestController;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Import({ AppConfig.class })
public class TrainingControllerTestAdd extends BaseTestController {

	static int trainingId = 0;

	@Test
	public void s_1_add() throws Exception {
		// name | prerequisites | toc
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/training/add");
		request.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		TrainingManager.createTrainingMySQL(request);
		
		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));

		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		trainingId = (Integer) object.get("id");
	}
	
	@Test
	public void s_2_add() throws Exception {
		// name | prerequisites | toc
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/training/add");
		request.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		TrainingManager.createTrainingHibernate(request);
		
		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));

		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		trainingId = (Integer) object.get("id");
	}
	
	@Test
	public void s_3_add() throws Exception {
		// name | prerequisites | toc
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/training/add");
		request.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		TrainingManager.createTrainingSpring(request);
		
		
		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));

		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		trainingId = (Integer) object.get("id");
	}

}