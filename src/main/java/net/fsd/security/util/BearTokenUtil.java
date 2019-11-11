package net.fsd.security.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@PropertySource("classpath:security.properties")
public class BearTokenUtil implements Serializable {

	private static final long serialVersionUID = 1;

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

 
	public String generateToken(UserDetails userDetails) {
		Date createTime = new Date();
		Date expiredTime = new Date(createTime.getTime() + expiration * 1000);
		Map<String, Object> claims = new HashMap<>();
		String token = Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(createTime)
				.setExpiration(expiredTime).signWith(SignatureAlgorithm.HS512, secret).compact();
		return token;
	}

	public Boolean isTokenExpired(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		Date expiredTime = claims.getExpiration();
		return expiredTime.before(new Date());
	}

	public String refreshToken(String token) {
		String refreshedToken;
		Date createTime = new Date();
		Date expiredTime = new Date(createTime.getTime() + expiration * 1000);

		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		claims.setIssuedAt(createTime).setExpiration(expiredTime);
		String refToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
		return refToken;
	}

	public Boolean validateToken(String token, UserDetails userDetails) throws Exception{
		User user = (User) userDetails;
		String userName = getUserNameFromToken(token);
		return (userName.equals(user.getUsername()) && !isTokenExpired(token));
	}

	public String getUserNameFromToken(String token) throws Exception{
		
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		String userName = claims.getSubject();
		return userName;
	}
}