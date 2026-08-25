package com.example.AutoComplete.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.redis.connection.Limit;
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

    public Set<String> findByPrefix(String prefix) {

        Range<String> range = Range.closed(prefix, prefix + Character.MAX_VALUE);

        Limit limit = Limit.limit().count(10);

        return redisTemplate.opsForZSet()
                .rangeByLex(KEY, range, limit);
    }
}
