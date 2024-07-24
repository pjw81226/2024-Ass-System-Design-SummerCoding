package org.landvibe.ass1.application.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.landvibe.ass1.common.annotation.CachingLandvibe;
import org.landvibe.ass1.common.annotation.CacheoutLandvibe;
import org.landvibe.ass1.infrastructure.manager.CacheManager;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class CachingAspect {

    private final CacheManager cacheManger;

    @Around("@annotation(cachingLandvibe)")
    public Object cachingLandvibe(ProceedingJoinPoint joinPoint, CachingLandvibe cachingLandvibe) throws Throwable {
        log.info("cachingLandvibe");
        String key = generateKey(joinPoint.getArgs(), cachingLandvibe.key()); //method parameter, annotation field 던짐
        String cacheName = cachingLandvibe.cacheManager();
        Object cacheData = cacheManger.getFromCache(cacheName, key);

        //존재하면 캐시에서 가져옴 cache hit
        if (cacheData != null) {
            return cacheData;
        }

        //존재하지 않을경우 메소드 실행 cache miss
        //이후에 캐시에 저장
        Object result = joinPoint.proceed();
        cacheManger.putToCache(cacheName, key, result);
        return result;
    }

    //cacheout 로직
    //update 메소드 이후에는 DB에 값을 직접 저장하므로, cache 저장되어있는 값을 빼내야한다.
    @AfterReturning("@annotation(cacheoutLandvibe)")
    public void evict(JoinPoint joinPoint, CacheoutLandvibe cacheoutLandvibe) {
        log.info("cacheoutLandvibe");
        String key = generateKey(joinPoint.getArgs(), cacheoutLandvibe.key()); //method parameter, annotation field 던짐
        String cacheName = cacheoutLandvibe.cacheManager();
        cacheManger.evictFromCache(cacheName, key);
    }



    private String generateKey(Object[] args, String keyTemplate) {
        for (int i = 0; i < args.length; i++) {
            keyTemplate = keyTemplate.replace("<arg" + i + ">", args[i].toString());
        }
        return keyTemplate;
    }
}
