package net.fsd.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fsd.entity.Payment;
import net.fsd.payment.service.IPaymentService;

@Controller
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	IPaymentService paymentService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String addPayment(Payment p) {
		paymentService.addPayment(p);
		return "success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List listPaymentDtls() {
		return paymentService.listPaymentDtls();
	}

}
