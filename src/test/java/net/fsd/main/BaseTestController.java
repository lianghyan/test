package net.fsd.main;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FsdApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTestController {
	protected String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkcmFnb25mbHkiLCJleHAiOjIwMDE0Njg2NzQsImlhdCI6MTU2OTQ2ODY3NH0.0SrO7Eh2taoGQyfPIxAWxUHIppE7hT4nq8nEiDunsK_qufs82iS3VC1-9zPqDSQ60-LhFl-bnZknd8LOpqtTWQ";
	protected MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	public void printResponse(ResultActions matcher) throws Exception {
		String responseStr = matcher.andReturn().getResponse().getContentAsString();
		System.out.println("return json = " + responseStr);
		System.out.println("---------------------------------------------");
	}
}
