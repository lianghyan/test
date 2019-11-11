package net.fsd.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.fsd.entity.FSDUser;
import net.fsd.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
	final static String baseQuery = "select t.id, t.status, t.progress, t.fees, t.commissionAmount, "
			+ "t.rating, t.startDate, t.endDate, t.startTime, t.endTime, t.amountReceived,"
			+ " t.razorpayPaymentId, t.desc,'xxx', m.userName,s.name " + "from Training t, FSDUser m, Skill s "
			+ "where t.mentorId=m.id and t.skillId=s.id ";

	@Transactional(readOnly = true)
	@Query(value = baseQuery + " and t.id=:id")
	public List findTrainingById(@Param("id") long id);
	
	@Transactional(readOnly = true)
	@Query(value = baseQuery )
	public List findAllTraining();
}
