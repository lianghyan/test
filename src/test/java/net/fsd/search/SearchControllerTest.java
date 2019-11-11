package net.fsd.search;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import net.fsd.main.AppConfig;
import net.fsd.main.BaseTestController;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Import({ AppConfig.class })
public class SearchControllerTest extends BaseTestController {

	// [{"id":1,"status":"normal","progress":30,"commissionAmout":3.0,"rating":0,"avgRating":0.0,"startDate":"2019/09/09","endDate":"2019/09/09","startTime":"09:00:00","endTime":"11:00:00","amountReceived":0.3,"userId":null,"userName":"xxx","mentorName":"happyday","skillId":null,"skillName":"Hibernate","fees":2000.0,"razorpayPaymentId":"normal"}]
	@Test
	public void findTrainingBySkillId() throws Exception {
		// "application/json;charset=UTF-8"
		ResultActions matcher = this.mockMvc
				.perform(post("/search/skill").header("Authorization", token).param("id", "" + 2)
						.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));

		printResponse(matcher);
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$").isArray());
		// matcher.andExpect(jsonPath("$[0].id").value(1));
		matcher.andExpect(jsonPath("$[0].skillName").value("MYSQL"));// skillName":"Hibernate"
	}

	@Test
	public void findTrainingByUserIdInProg() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/search/userprog").header("Authorization", token).param("id", "" + 1)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		printResponse(matcher);
		matcher.andDo(MockMvcResultHandlers.print());
		// matcher.andExpect(jsonPath("$[0].userName").value("happyday"));
		String[] expectedNames = { "usky", "ustar", "msky" };
		Matchers.containsInAnyOrder(expectedNames).matches(jsonPath("$[0].userName"));
	}

	@Test
	public void findTrainingByUserIdComp() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/search/usercomp").header("Authorization", token).param("id", "" + 1)
						.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
		printResponse(matcher);
		matcher.andDo(MockMvcResultHandlers.print());
		String[] expectedNames = { "usky", "ustar" };
		List list = Arrays.asList(expectedNames);
		matcher.andExpect(jsonPath("$[0].userName", Matchers.anyOf( is(expectedNames[0]), is(expectedNames[1]))));
		//matcher.andExpect(jsonPath("$[0].userName", Matchers.arrayContaining(expectedNames)));
	}


	@Test
	public void findTrainingByMentorIdInProg() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/search/mentorprog").header("Authorization", token).param("id", "" + 3)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		printResponse(matcher);
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$[0].mentorName").value("msky"));

	}


	@Test
	public void findTrainingByMentorIdCompleted() throws Exception {
		ResultActions matcher = this.mockMvc
				.perform(post("/search/mentorcomp").header("Authorization", token).param("id", "" + 3)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		printResponse(matcher);
		matcher.andDo(MockMvcResultHandlers.print());
		matcher.andExpect(jsonPath("$[0].id").value(3));
		matcher.andExpect(jsonPath("$[0].mentorName").value("msky"));
	}}