package com.qb.question_bank_restapi.database;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CachingSystem {
    private static volatile CachingSystem instance;
    private static final Cache<String,Boolean> usernameCache = Caffeine.newBuilder()
            .maximumSize(1000000)
            .expireAfterWrite(31, TimeUnit.DAYS)
            .build();
    private CachingSystem() {
        // Private constructor to prevent direct instantiation
    }

    public static CachingSystem getInstance() {

        if (instance == null) {
            synchronized (CachingSystem.class) {
                if (instance == null) {
                    instance = new CachingSystem();
                }
            }
        }
        return instance;
    }

    public static void setUsernameCache(String username){
        usernameCache.put(username,true);
    }
    public static Boolean getUsernameCache(String username){
        return usernameCache.getIfPresent(username);
    }
}

