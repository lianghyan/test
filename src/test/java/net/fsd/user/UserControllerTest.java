package net.fsd.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.fsd.main.BaseTestController;
import net.fsd.user.main.AppConfigUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Import({ AppConfigUser.class })
public class UserControllerTest extends BaseTestController {
	static int userId=0;

	// @Test
	public void login() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/auth/login").param("username", "usky").param("password", "111111")
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		// matcher.andExpect(jsonPath("$.id").value(2));
	}

	@Test
	public void u_1_add() throws Exception {
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
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		JSONObject object=(JSONObject) JSONObject.parseObject(responseStr);
		userId = (Integer) object.get("id");
		printResponse(matcher);
	}

	@Test
	public void u_2_findById() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/user/finduser").param("userId", ""+userId).header("Authorization", token).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.id").value(userId));
	}

	@Test
	public void u_3_updatePwd() throws Exception {
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		ResultActions matcher = this.mockMvc
				.perform(post("/user/updatepwd").header("Authorization", token).param("pwd", en.encode("111111"))
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.ret").value("success"));
	}

	@Test
	public void u_4_update() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/user/update").param("userId", ""+userId).param("userName", "dragonfly").param("password", "xxxx")
						.param("firstName", "dragon").param("lastName", "fly").param("contactNumber", "0411-8888")
						.param("role", "user").param("linkedUrl", "xxxxx").param("active", "true")
						.param("confirmedSignUp", "true").param("resetPassword", "true")
						.param("resetPasswordDate", "2019/01/01").header("Authorization", token)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.ret").value("success"));
	}
	
	@Test
	public void u_5_delete() throws Exception {
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		ResultActions matcher = this.mockMvc
				.perform(post("/user/delete").param("userId", ""+userId).header("Authorization", token)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.ret").value("success"));
	}
	@Test
	public void u_6_listuser() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("fromserver", "MicroSVr test");
		ObjectMapper mapper = new ObjectMapper();
		RequestBuilder request = MockMvcRequestBuilders.post("/user/listuser").content(mapper.writeValueAsString(map))
				.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));// application/json;charset=UTF-8
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$").isArray());
		printResponse(matcher);
	}

	@Test
	public void u_6_listMentor() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/user/listmentor").header("Authorization", token).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$").isArray());
	}


}
