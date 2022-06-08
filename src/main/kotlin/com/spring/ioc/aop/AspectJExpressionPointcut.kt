package com.spring.ioc.aop

import org.aspectj.weaver.tools.PointcutExpression
import org.aspectj.weaver.tools.PointcutParser
import org.aspectj.weaver.tools.PointcutPrimitive
import java.lang.reflect.Method

class AspectJExpressionPointcut() : Pointcut, ClassFilter, MethodMatcher {

    private var pointcutParser: PointcutParser? = null
    private var pointcutExpression: PointcutExpression? = null

    var expression: String? = null

    companion object {
        val DEFAULT_SUPPORTED_PRIMITIVES: Set<PointcutPrimitive> = setOf(
            PointcutPrimitive.EXECUTION,
            PointcutPrimitive.ARGS,
            PointcutPrimitive.REFERENCE,
            PointcutPrimitive.THIS,
            PointcutPrimitive.TARGET,
            PointcutPrimitive.WITHIN,
            PointcutPrimitive.AT_ANNOTATION,
            PointcutPrimitive.AT_WITHIN,
            PointcutPrimitive.AT_ARGS,
            PointcutPrimitive.AT_TARGET
        )
    }

    init {
        pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(
            DEFAULT_SUPPORTED_PRIMITIVES
        )
    }

    override fun getClassFilter(): ClassFilter {
        return this
    }

    override fun getMethodMatcher(): MethodMatcher {
        return this
    }

    override fun matches(targetClass: Class<*>): Boolean {
        checkReadyToMatch()
        return pointcutExpression?.couldMatchJoinPointsInType(targetClass) ?: false
    }

    override fun matches(method: Method, targetClass: Class<*>): Boolean {
        checkReadyToMatch()
        val shadowMatch = pointcutExpression?.matchesMethodExecution(method)
        return shadowMatch?.alwaysMatches() == true
    }

    private fun checkReadyToMatch() {
        if (pointcutExpression == null) { pointcutExpression = buildPointExpression() }
    }

    private fun buildPointExpression(): PointcutExpression? {
        return pointcutParser?.parsePointcutExpression(expression)
    }
}
