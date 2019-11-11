package net.fsd.security.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.fsd.entity.FSDUser;
import net.fsd.security.service.FSDUserDetailsService;

@RestController
public class LoginController {

    @Autowired
    private FSDUserDetailsService authService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public String createToken( String username,String password ) throws AuthenticationException {
        return authService.login( username, password );
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public FSDUser register( @RequestBody FSDUser addedUser ) throws AuthenticationException {
        return authService.register(addedUser);
    }

}