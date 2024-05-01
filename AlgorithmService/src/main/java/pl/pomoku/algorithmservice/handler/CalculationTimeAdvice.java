package pl.pomoku.algorithmservice.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

@Aspect
@Component
public class CalculationTimeAdvice {
    @Around("@annotation(pl.pomoku.algorithmservice.annotations.MeasureCalculationTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        if(proceed instanceof AbstractCalculationTime) {
            ((AbstractCalculationTime<?>) proceed).setTime(executionTime);
        }
        return proceed;
    }
}
