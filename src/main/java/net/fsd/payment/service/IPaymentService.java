package net.fsd.payment.service;

import java.util.List;

import net.fsd.entity.Payment;

public interface IPaymentService {

	void addPayment(Payment p);

	List listPaymentDtls();

}
