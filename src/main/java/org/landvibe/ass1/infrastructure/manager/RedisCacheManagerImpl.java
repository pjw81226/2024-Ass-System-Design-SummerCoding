package org.landvibe.ass1.infrastructure.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisCacheManagerImpl implements CacheManager {
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object getFromCache(String cacheName, String key) {
        return redisTemplate.opsForHash().get(cacheName, key);
    }

    @Override
    public void putToCache(String cacheName, String key, Object value) {
        redisTemplate.opsForHash().put(cacheName, key, value);
    }

    @Override
    public void evictFromCache(String cacheName, String key) {
        redisTemplate.opsForHash().delete(cacheName, key);
    }
}
