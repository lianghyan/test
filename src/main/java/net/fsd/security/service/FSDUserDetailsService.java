package net.fsd.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.fsd.comm.dao.UserRepository;
import net.fsd.entity.FSDUser;
import net.fsd.security.util.BearTokenUtil;

@Service
public class FSDUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

//	@Autowired
//	private AuthenticationManager authenticationManager;

	@Autowired
	private BearTokenUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("--------------try to find user: " + userName);
		FSDUser fsduser = userRepository.getUserByName(userName);
		if (null == fsduser) {
			throw new UsernameNotFoundException(userName);
		}
		String un = fsduser.getUserName();
		String pwd = fsduser.getPassword();
		String role = fsduser.getRole();

		List<SimpleGrantedAuthority> auList = new ArrayList<>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role);
		auList.add(sga);
		User u = new User(un, pwd, auList);
		return u;
	}

	public String login(String username, String password) {
//		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
//		final Authentication authentication = authenticationManager.authenticate(upToken);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = loadUserByUsername(username);
		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}
	// 注册

	public FSDUser register(FSDUser userToAdd) {
		final String username = userToAdd.getUserName();
		if (userRepository.getUserByName(username) != null) {
			return null;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		final String rawPassword = userToAdd.getPassword();
		userToAdd.setPassword(encoder.encode(rawPassword));
		return userRepository.save(userToAdd);
	}

	public String saveUserLoginInfo(UserDetails principal) {
 		return null;
	}
	public static void main(String args[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword="111111";
		String enPwd=encoder.encode(rawPassword);
		System.out.println(enPwd);
	}

}
