package rp.zut.lab05.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import rp.zut.lab05.components.Car;

@Slf4j
@Aspect
@Component
public class Metrics {

    @Around("execution(* rp.zut.lab05.components.Car.run(..))")
    public void routeTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Car car = (Car) joinPoint.getTarget();
        int routeLength = car.getRouteLength();
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Route length: " + routeLength + " km, Time taken: " + duration + " ms");
    }

    @Before("execution(* rp.zut.lab05.components.Engine.start(..))")
    public void logEngineStart() {
        log.info("Engine is starting...");
    }

    @AfterReturning("execution(* rp.zut.lab05.components.Engine.start(..))")
    public void logEngineStartSuccess() {
        log.info("Engine started successfully.");
    }

    @AfterThrowing("execution(* rp.zut.lab05.components.Engine.start(..))")
    public void logEngineStartFailure() {
        log.info("Engine failed to start.");
    }
}