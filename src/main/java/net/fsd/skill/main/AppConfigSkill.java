package net.fsd.skill.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"net.fsd.model","net.fsd.security", "net.fsd.comm.log",
	"net.fsd.skill.controller","net.fsd.skill.service"})
@EntityScan("net.fsd.entity")
@EnableJpaRepositories({"net.fsd.skill.dao","net.fsd.comm.dao"})
//@ComponentScan("net.fsd.model, net.fsd.skill.*, net.fsd.security")
//@EnableJpaRepositories(basePackages = {"com.xx","com.yy"})
//@EntityScan(basePackages = {"com.xx","com.yy"})
public class AppConfigSkill {

}
