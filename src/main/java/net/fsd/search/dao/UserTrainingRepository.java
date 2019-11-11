package net.fsd.search.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.fsd.entity.UserTraining;

@Repository
public interface UserTrainingRepository extends JpaRepository<UserTraining, Long> {
	@Transactional(readOnly = true)
	@Query(value = "SELECT u FROM UserTraining u WHERE userId=:userId")
	public List listUserTraining(@Param("userId") long userId);

}