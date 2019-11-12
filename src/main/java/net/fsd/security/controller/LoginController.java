package net.fsd.security.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.fsd.entity.FSDUser;
import net.fsd.security.service.FSDUserDetailsService;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private FSDUserDetailsService authService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public String findTokenRole( String username,String password ) throws AuthenticationException {
    	//Access-Control-Allow-Origin = http://localhost:4200
    	System.out.println("LoginController:>>>>>>>>>>>"+username+":"+password);
        //return authService.login( username, password );
    	String[] userInfo=authService.login( username, password );
    	
    	return "{\"token\":\""+userInfo[0]+"\", \"role\":\""+userInfo[1]+"\",\"userId\":"+userInfo[2]+"}";
   }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public FSDUser register( @RequestBody FSDUser addedUser ) throws AuthenticationException {
        return authService.register(addedUser);
    }

}