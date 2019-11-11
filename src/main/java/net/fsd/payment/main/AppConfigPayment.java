package net.fsd.payment.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"net.fsd.model","net.fsd.security", "net.fsd.comm.log",
	"net.fsd.payment.controller","net.fsd.payment.service"})
@EntityScan("net.fsd.entity")
@EnableJpaRepositories({"net.fsd.payment.dao","net.fsd.comm.dao"})
//@ComponentScan("net.fsd.model, net.fsd.payment.*, net.fsd.security")
//@EnableJpaRepositories(basePackages = {"com.xx","com.yy"})
//@EntityScan(basePackages = {"com.xx","com.yy"})
public class AppConfigPayment {

}
