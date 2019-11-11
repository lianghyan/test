package net.fsd.training.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"net.fsd.model","net.fsd.security", "net.fsd.comm.log",
	"net.fsd.training.service","net.fsd.training.controller"})
//@ComponentScan("net.fsd.model,net.fsd.security, net.fsd.comm.log,net.fsd.training.service, net.fsd.training.controller")
@EntityScan("net.fsd.entity")
@EnableJpaRepositories({"net.fsd.training.dao","net.fsd.comm.dao"})
//@EnableJpaRepositories(basePackages = {"com.xx","com.yy"})
//@EntityScan(basePackages = {"com.xx","com.yy"})
public class AppConfigTraining {

}
