package net.fsd.comm.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogPointCut {

	@Pointcut("execution(public * net.fsd..controller.*.*(..))") // the pointcut expression
	public void log() {
	}

}
