package com.spring.ioc.aop

import org.aopalliance.intercept.MethodInterceptor

class AdvisedSupport() {
    var targetSource: TargetSource? = null
    var methodInterceptor: MethodInterceptor? = null
}
