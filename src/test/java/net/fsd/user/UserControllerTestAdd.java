package net.fsd.user;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.fsd.main.BaseTestController;
import net.fsd.user.main.AppConfigUser;

@Import({ AppConfigUser.class })
public class UserControllerTestAdd extends BaseTestController {
	static long userid = 0;

	@Test
	public void u_1_add() throws Exception {
		Map<String, Object> map = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/add");
		request.content(mapper.writeValueAsString(map)).header("Authorization", token)
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		UserManager.createUser(request);
		// UserManager.createUser1(request);
		// UserManager.createMentor(request);
//		UserManager.createAdmin(request);
		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=UTF-8"));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		int userId = (Integer) object.get("id");
		printResponse(matcher);
	}

	@Test
	public void u_2_add() throws Exception {
		Map<String, Object> map = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/add");
		request.content(mapper.writeValueAsString(map)).header("Authorization", token)
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		// UserManager.createUser(request);
		UserManager.createUser1(request);
		// UserManager.createMentor(request);
		// UserManager.createAdmin(request);
		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=UTF-8"));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		int userId = (Integer) object.get("id");
		printResponse(matcher);
	}

	@Test
	public void u_3_add() throws Exception {
		Map<String, Object> map = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/add");
		request.content(mapper.writeValueAsString(map)).header("Authorization", token)
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		// UserManager.createUser(request);
		// UserManager.createUser1(request);
		UserManager.createMentor(request);
		// UserManager.createAdmin(request);
		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=UTF-8"));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		int userId = (Integer) object.get("id");
		printResponse(matcher);
	}

	@Test
	public void u_4_add() throws Exception {
		Map<String, Object> map = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/add");
		request.content(mapper.writeValueAsString(map)).header("Authorization", token)
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		// UserManager.createUser(request);
		// UserManager.createUser1(request);
		// UserManager.createMentor(request);
		UserManager.createAdmin(request);
		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=UTF-8"));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object = (JSONObject) JSONObject.parseObject(responseStr);
		int userId = (Integer) object.get("id");
		printResponse(matcher);
	}
}
