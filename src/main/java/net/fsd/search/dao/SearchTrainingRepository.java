package net.fsd.search.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.fsd.entity.Training;
import net.fsd.model.UserDtls;

@Repository
public interface SearchTrainingRepository extends JpaRepository<Training, Long> {
	final static String userQuery = "select t.id, t.status, t.progress, t.fees, t.commissionAmount, "
			+ "t.rating, t.startDate, t.endDate, t.startTime, t.endTime, t.amountReceived,"
			+ " t.razorpayPaymentId, u.userName, m.userName,s.name "
			+ "from Training t, UserTraining ut, FSDUser u, FSDUser m, Skill s "
			+ "where t.id=ut.trainingId and ut.userId=u.id and t.mentorId=m.id and t.skillId=s.id ";

	final static String baseQuery = "select t.id, t.status, t.progress, t.fees, t.commissionAmount, "
			+ "t.rating, t.startDate, t.endDate, t.startTime, t.endTime, t.amountReceived,"
			+ " t.razorpayPaymentId,'xxx', m.userName,s.name " + "from Training t, FSDUser m, Skill s "
			+ "where t.mentorId=m.id and t.skillId=s.id ";

	// baseQuery + " and t.progress<100 and t.skillId=" + skillId;
	@Transactional(readOnly = true)
	@Query(value = baseQuery + " and t.progress<100 and t.skillId=:skillId")
	public List findTrainingBySkillId(@Param("skillId") long skillId);

	// String query = userQuery + " and t.progress<100 and u.id=" + userId;
	@Transactional(readOnly = true)
	@Query(value = userQuery + " and t.progress<100 and u.id=:userId")
	public List findTrainingByUserIdInProg(@Param("userId") long userId);
	
	//String query = userQuery + " and t.progress=100 and u.id=" + userId;
	@Transactional(readOnly = true)
	@Query(value = userQuery + " and t.progress=100 and u.id=:userId")
	public List findTrainingByUserIdCompleted(@Param("userId")long userId);
	
	//String query = baseQuery + " and t.progress<100 and m.id=" + mentorId;
	@Transactional(readOnly = true)
	@Query(value = baseQuery + " and t.progress<100 and m.id=:mentorId")
	public List  findTrainingByMentorIdInProg(@Param("mentorId")long mentorId);
	
	//String query = baseQuery + " and t.progress=100 and m.id=" + mentorId;
	@Transactional(readOnly = true)
	@Query(value = baseQuery + " and t.progress=100 and m.id=:mentorId")
	public List findTrainingByMentorIdCompleted(@Param("mentorId")long mentorId);
		

}
