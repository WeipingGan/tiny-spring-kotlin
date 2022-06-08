package com.spring.ioc.aop

import com.spring.ioc.HelloWorldService
import com.spring.ioc.HelloWorldServiceImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AspectJExpressionPointcutTest {

    @Test
    fun `class filter should match`() {
        val expression = "execution(* com.spring.ioc.*.*(..))"
        val aspectJExpressionPointcut = AspectJExpressionPointcut()
        aspectJExpressionPointcut.expression = expression
        val matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService::class.java)
        Assertions.assertTrue(matches)
    }

    @Test
    fun `method filter should match`() {
        val expression = "execution(* com.spring.ioc.*.*(..))"
        val aspectJExpressionPointcut = AspectJExpressionPointcut()
        aspectJExpressionPointcut.expression = expression
        val declaredMethod = HelloWorldServiceImpl::class.java.getDeclaredMethod(
            "helloWorld"
        )
        val matches = aspectJExpressionPointcut.getMethodMatcher().matches(
            declaredMethod, HelloWorldServiceImpl::class.java
        )
        Assertions.assertTrue(matches)
    }
}
