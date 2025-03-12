package com.example_effigo.cache.service;

import com.example_effigo.cache.entity.User;
import com.example_effigo.cache.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final CacheManager cacheManager;

    @Autowired
    public UserService(UserRepository userRepository, CacheManager cacheManager) {
        this.userRepository = userRepository;
        this.cacheManager = cacheManager;
    }

    @Cacheable(value = "cached_users", key = "#id")
    public Optional<User> getUserById(long id) {
        logger.info("Fetching user from DB: {}", id);
        return userRepository.findById(id);
    }

    @CacheEvict(value = "users", key = "#id")
    public void evictUserFromCache(long id) {
        logger.info("User removed from Cache: {}", id);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void clearCache() {
        logger.info("Clearing users cache");
    }

    @CachePut(value = "users", key = "#user.id")
    public User saveUser(User user) {
        logger.info("Saving user to DB and updating cache: {}", user);
        return userRepository.save(user);
    }

    public boolean isUserInCache(long id) {
        Cache cache = cacheManager.getCache("users");
        if (cache == null) {
            return false;
        }
        return cache.get(id) != null;
    }
}
