package com.springjpa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Order(5)
@Component
public class WebLogAspect {

	private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.springjpa.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("1111111111111111111111 doBefore() is running!");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        
        logger.info("hijacked : " + joinPoint.getSignature().getName());
        logger.info("******");
    }
    
    @After("webLog()")
	public void logAfter(JoinPoint joinPoint) {

		logger.info("2222222222222222222222 logAfter() is running!");
		logger.info("hijacked : " + joinPoint.getSignature().getName());
		logger.info("******");

	}

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        // 处理完请求，返回内容
    	logger.info("3333333333333333333333 doAfterReturning() is running!");
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        
		logger.info("hijacked : " + joinPoint.getSignature().getName());
		logger.info("Method returned value is : " + ret);
		logger.info("******");
    }

	@AfterThrowing(pointcut = "webLog()", throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		logger.info("444444444444444444444 logAfterThrowing() is running!");
		logger.info("hijacked : " + joinPoint.getSignature().getName());
		logger.info("Exception : " + error);
		logger.info("******");

	}
	
    /*
	@Around("execution(* com.springjpa.controller..*.*(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		logger.info("55555555555555555555 logAround() is running!");
		logger.info("hijacked method : " + joinPoint.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		logger.info("Around before is running!");
		joinPoint.proceed();
		logger.info("55555555555555555555 Around after is running!");
		
		logger.info("******");

	}
	*/
}

