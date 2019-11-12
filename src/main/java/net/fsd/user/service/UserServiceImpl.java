package net.fsd.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fsd.entity.FSDUser;
import net.fsd.user.dao.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userDAO;

	@Override
	public FSDUser addUser(FSDUser u) {
		return userDAO.saveAndFlush(u);
	}

	@Override
	public void updateUser(FSDUser u) {
		userDAO.saveAndFlush(u);
	}

	@Override
	public void deleteUser(long userId) {
		userDAO.delete(new FSDUser(userId));
	}

	public FSDUser findUser(long id) {
		return userDAO.findById(id).get();
	}

	@Override
	public List listUser() {
		return userDAO.listUsers("user");
	}

	@Override
	public List listMentor() {
		return userDAO.listUsers("mentor");
	}
	
	public void updatePwd(String pwd) {
		userDAO.updatePwd(pwd);
	}
}
