package com.woozooha.demo.config;

import com.woozooha.adonistrack.aspect.ProfileAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdonisTrackAspect extends ProfileAspect {

    @Pointcut("execution(* *(..)) && (" +
            "within(com.woozooha.demo..*) || " +
            "within(org.springframework.data.repository.Repository+)" +
            ") && !within(com.woozooha.demo.config..*)")
    public void executionPointcut() {
    }

    @Override
    protected boolean useMemoryWriter() {
        return false;
    }

    @Override
    protected boolean useFileWriter() {
        return true;
    }

}
