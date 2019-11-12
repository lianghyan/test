package net.fsd.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.fsd.entity.FSDUser;

@Repository(value="userRepository")
public interface UserRepository extends JpaRepository<FSDUser, Long> {

	@Transactional(readOnly = true)
	@Query(value = "SELECT u FROM FSDUser u WHERE role=:role")
	public List<FSDUser> listUsers(@Param("role") String role);

	@Transactional(readOnly = true)
	@Query(value = "SELECT u FROM FSDUser u WHERE userName=:userName")
	public FSDUser getUserByName(@Param("userName") String userName);

	@Transactional()
    @Modifying
    @Query(value = "update FSDUser set password=:password",nativeQuery = true)
    int updatePwd(@Param("password") String password);
}
