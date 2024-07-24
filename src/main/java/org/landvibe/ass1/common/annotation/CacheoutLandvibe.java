package org.landvibe.ass1.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheoutLandvibe {
    String key();
    String cacheManager() default "books"; // 캐싱의 대상
}
