package com.spring.ioc.aop

import org.aopalliance.intercept.MethodInvocation
import java.lang.reflect.AccessibleObject
import java.lang.reflect.Method

class ReflectiveMethodInvocation(private var target: Any, private val method: Method?, private var args: Array<Any>?) :
    MethodInvocation {
    override fun proceed(): Any {
        return if (args.isNullOrEmpty()) {
            method!!.invoke(target)
        } else {
            // Todo()
        }
    }

    override fun getThis(): Any {
        return target
    }

    override fun getStaticPart(): AccessibleObject {
        return method as AccessibleObject
    }

    override fun getArguments(): Array<Any>? {
        return args
    }

    override fun getMethod(): Method? {
        return method
    }
}
