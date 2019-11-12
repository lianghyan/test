package net.fsd.payment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import net.fsd.main.BaseTestController;
import net.fsd.payment.main.AppConfigPayment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Import({ AppConfigPayment.class })
public class PaymentControllerTest_Add extends BaseTestController {

	@Test
	public void p_1_add() throws Exception {
		// name | prerequisites | toc
		ResultActions matcher = this.mockMvc
				.perform(post("/payment/add").param("trainingId", "1").param("userId", "1").param("payProgress", "30")
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

		matcher.andExpect(content().string("success"));
	}

	@Test
	public void p_2_add() throws Exception {
		// name | prerequisites | toc
		ResultActions matcher = this.mockMvc
				.perform(post("/payment/add").param("trainingId", "1").param("userId", "2").param("payProgress", "60")
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

		matcher.andExpect(content().string("success"));
	}

}