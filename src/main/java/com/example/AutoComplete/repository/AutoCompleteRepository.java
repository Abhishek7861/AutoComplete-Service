package com.example.AutoComplete.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class AutoCompleteRepository {
    private static final String KEY = "autocomplete:terms";
    private final RedisTemplate<String, String> redisTemplate;

    public AutoCompleteRepository(
            RedisTemplate<String, String> redisTemplate) {

        this.redisTemplate = redisTemplate;
    }

    public void addTerm(String term, double score) {

        Boolean added = redisTemplate.opsForZSet()
                .add(KEY, term, score);
        if (Boolean.TRUE.equals(added)) {
            System.out.println("New term added: " + term);
        } else {
            System.out.println("Existing term updated: " + term);
        }
    }
}
