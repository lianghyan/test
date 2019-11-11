package net.fsd.user.service;

import java.util.List;

import net.fsd.entity.FSDUser;

public interface IUserService {
	public FSDUser addUser(FSDUser u);

	public void updateUser(FSDUser u);

	public List listUser();

	public List listMentor();

	public void deleteUser(long userId);

	public FSDUser findUser(long userId);

	public void updatePwd(String pwd);
}
