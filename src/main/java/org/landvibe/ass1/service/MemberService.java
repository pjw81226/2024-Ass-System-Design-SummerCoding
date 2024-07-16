package org.landvibe.ass1.service;

import org.landvibe.ass1.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MemberService {
    private RedisTemplate<String, String> redisTemplate;
    private RedisTemplate<String, Member> redisTemplateMember;
    private AtomicInteger idFactory;

    @Autowired
    public MemberService(RedisTemplate<String, String> redisTemplate ,
                         RedisTemplate<String, Member> redisTemplateMember) {
        this.redisTemplate = redisTemplate;
        this.redisTemplateMember = redisTemplateMember;
        this.idFactory = new AtomicInteger(0);
    }

    public void add(String name) {
        int id = idFactory.getAndIncrement();
        Member member = new Member(id, name);
        String key = "member" + Integer.toString(id);
        String keyObject = "memberObject:" + Integer.toString(id);
        redisTemplate.opsForValue().set(key, name);
        redisTemplateMember.opsForValue().set(keyObject,member,Duration.ofSeconds(40));
    }

    public Member get(int id) {
        String keyObject = "memberObject:" + Integer.toString(id);
        Member member = redisTemplateMember.opsForValue().get(keyObject);
        return member;
    }
}
