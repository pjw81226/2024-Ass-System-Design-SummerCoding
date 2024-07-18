package org.landvibe.ass1.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RequestCounterAspect {

    private final RedisTemplate<String, Object> redisTemplate;

    public RequestCounterAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Before("execution(* org.landvibe.ass1.presentation.controller.*.*(..))")
    public void countRequest(JoinPoint joinPoint) {
        String serverName = System.getenv("SERVER_NAME");
        log.debug("Incrementing request count for server: " + serverName);
        redisTemplate.opsForValue().increment("request_count:" + serverName);
    }
}

