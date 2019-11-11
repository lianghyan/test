package net.fsd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import net.fsd.main.BaseTestController;
import net.fsd.user.main.AppConfigUser;


@Import({ AppConfigUser.class })
public class SimpleControllerTest extends BaseTestController {

	static int trainingId = 2;
	static int userId=1;

	@Test
	public void u_2_findById() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/user/finduser").param("userId", ""+userId).header("Authorization", token).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$.id").value(userId));
	}

}