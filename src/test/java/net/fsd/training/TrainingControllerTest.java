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
public class TrainingControllerTest extends BaseTestController {

	static int trainingId = 0;

	@Test
	public void s_1_add() throws Exception {
		// name | prerequisites | toc
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/training/add");
		request.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		TrainingManager.createForDelete(request);

		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));

		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		trainingId = (Integer) object.get("id");
	}

	@Test
	public void s_2_update() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/training/update");
		request.header("Authorization", token).param("trainingId", "" + trainingId)
				.contentType(MediaType.APPLICATION_JSON_UTF8);

		TrainingManager.createForUpdate(request);

		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

		matcher.andExpect(jsonPath("$.ret").value("success"));
	}

	@Test
	public void s_3_list() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/training/list").header("Authorization", token).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

		matcher.andExpect(jsonPath("$").isArray());
	}
	
	@Test
	public void s_4_findById() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/training/find").header("Authorization", token).param("trainingId", "" + trainingId)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		printResponse(matcher);
		matcher.andExpect(jsonPath("$.id").value(trainingId));

	}
	

	@Test
	public void s_5_delete() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/training/delete").header("Authorization", token).param("trainingId", "" + trainingId)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

		matcher.andExpect(jsonPath("$.ret").value("success"));
	}
}