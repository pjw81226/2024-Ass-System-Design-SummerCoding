package org.landvibe.ass1.infrastructure.manager;

public interface CacheManger {
    Object getFromCache(String cacheName, String key);
    void putToCache(String cacheName, String key, Object value);
    void evictFromCache(String cacheName, String key);
}
