package idu.cs.controller.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    Logger logger =  LoggerFactory.getLogger(LogAspect.class);
    
    //UserService의 모든 메서드
    @Around("execution(* idu.cs.service.UserService.*(..))")
    /*@Around("execution(* idu.cs.springboot.board.controller..*.*(..))")*/
    /*@Around("execution(* idu.cs.springboot.board..*.*(..))")*/
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        return result;
    } //실행하기 전후에 뭐한다고? 확인?
}