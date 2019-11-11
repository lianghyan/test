package net.fsd.skill;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.fsd.main.BaseTestController;
import net.fsd.skill.main.AppConfigSkill;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Import({ AppConfigSkill.class })
public class SkillControllerTestsAdd extends BaseTestController {

	@Test
	public void s_1_add() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/skill/add");
		request.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		SkillManager.createHibernate(request);
		// SkillManager.createMYSQL(request);
		//SkillManager.createSpring(request);

		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
	}

	@Test
	public void s_2_add() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/skill/add");
		request.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		//SkillManager.createHibernate(request);
		 SkillManager.createMYSQL(request);
		//SkillManager.createSpring(request);

		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
	}

	@Test
	public void s_3_add() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/skill/add");
		request.header("Authorization", token).contentType(MediaType.APPLICATION_JSON_UTF8);

		//SkillManager.createHibernate(request);
		// SkillManager.createMYSQL(request);
		SkillManager.createSpring(request);

		ResultActions matcher = this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		matcher.andExpect(jsonPath("$.id").isNumber());
		matcher.andExpect(jsonPath("$.ret").value("success"));
	}

}