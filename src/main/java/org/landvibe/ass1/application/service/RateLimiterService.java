package org.landvibe.ass1.application.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {
    private final RateLimiter rateLimiter = RateLimiter.create(10.0); // 초당 10개의 요청 허용

    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }
}