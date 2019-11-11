package net.fsd.user.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EntityScan("net.fsd.entity")
@EnableJpaRepositories({"net.fsd.user.dao","net.fsd.comm.dao"})
@ComponentScan({ "net.fsd.model", "net.fsd.security", "net.fsd.comm.log",
		"net.fsd.user.controller", "net.fsd.user.service" })
//@ComponentScan("net.fsd.model, net.fsd.security, net.fsd.comm.log, net.fsd.user.controller, net.fsd.user.service")

//@EnableJpaRepositories(basePackages = {"com.xx","com.yy"})
//@EntityScan(basePackages = {"com.xx","com.yy"})
public class AppConfigUser {

}
