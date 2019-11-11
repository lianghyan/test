package net.fsd.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fsd.entity.Payment;
import net.fsd.model.PaymentDtls;
import net.fsd.payment.dao.PaymentRepository;

@Service(value = "paymentService")
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	PaymentRepository paymentDAO;

	@Override
	public void addPayment(Payment p) {
		paymentDAO.save(p);
	}

	@Override
	public List listPaymentDtls() {
		List<Object[]> queryList = paymentDAO.listPaymentDtls();
		// p.id, p.payProgress, t.id, s.name as trainDesc, m.userName
		List<PaymentDtls> ret = new ArrayList<PaymentDtls>();
		queryList.forEach(objs -> {
			Object[] arr = (Object[]) objs;
			PaymentDtls td = new PaymentDtls();
			td.setId((Long) arr[0]);
			td.setPayProgress((Integer) arr[1]);
			td.setTrainingId((Long) arr[2]);
			td.setTrainingDes((String) arr[3]);
			td.setMentorName((String) arr[4]);
			ret.add(td);
		});
		return ret;

	}
}
