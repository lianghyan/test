package net.fsd.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.fsd.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
 
 	@Transactional(readOnly = true)
	@Query(value = "select p.id, p.payProgress, t.id as trainingId, s.name as trainDesc, m.userName from Payment p, Training t, FSDUser m, Skill s where p.trainingId=t.id and p.userId=m.id and t.skillId=s.id")
	public List listPaymentDtls();
}
