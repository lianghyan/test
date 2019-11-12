package net.fsd.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"net.fsd.model", "net.fsd.security", "net.fsd.scheduler", "net.fsd.comm.log",
	"net.fsd.*.service", "net.fsd.*.controller"})

//@ComponentScan("net.fsd.model, net.fsd.*.service, net.fsd.*.controller, net.fsd.security, net.fsd.comm.log")
@EntityScan("net.fsd.entity")
@EnableJpaRepositories("net.fsd.*.dao")
//@EnableAspectJAutoProxy

//@EnableJpaRepositories(basePackages = {"com.xx","com.yy"})
//@EntityScan(basePackages = {"com.xx","com.yy"})
public class AppConfig {

}
