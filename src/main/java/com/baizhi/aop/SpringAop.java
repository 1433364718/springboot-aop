package com.baizhi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @Aspect定义该类为切面类
 * @Configuration定义该类为配置类（不能少）
 */
@Aspect
@Configuration
public class SpringAop {

    // 定义切入点(可写可不写)，写的话下面织入的时候可直接写该切入点方法名，
    // 不写的话可织入execution(* com.baizhi.controller.*.*(..))
    @Pointcut("execution(* com.baizhi.controller.*.*(..))")
    public void pp(){}

   /*// 前置增强
    @Before("pp()")
    public void before(JoinPoint joinPoint){

        // 方法参数 
        Object[] args = joinPoint.getArgs();

        // 代理对象
        Object aThis = joinPoint.getThis();

        // 目标类的对象
        Object target = joinPoint.getTarget();

        // 方法对象
        Signature signature = joinPoint.getSignature();
        System.out.println("前置增强");

    }

    // 后置增强
    @AfterReturning("pp()")
    public void after(JoinPoint joinPoint){
        System.out.println("后置增强");
    }


    // 异常增强
   @AfterThrowing("pp()")
   public void afterThrowing(JoinPoint joinPoint){
       System.out.println("异常增强");
    }*/

    // 环绕增强
    @Around("execution(* com.baizhi.controller.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        // 放行上面为前置增强的代码
        System.out.println("环绕增强的前置增强");
        Object proceed=null;
        try {
            // 放行 proceed为目标类的方法返回值
            proceed = proceedingJoinPoint.proceed();

            // 放行下面为后置增强的代码
            System.out.println("环绕增强的后置增强");
        } catch (Throwable throwable) {

            // catch里为异常增强的代码
            System.out.println("环绕增强的异常增强");
            throwable.printStackTrace();
        }
        return proceed;
    }
}
