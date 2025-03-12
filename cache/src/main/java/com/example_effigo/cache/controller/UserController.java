package com.example_effigo.cache.controller;

import com.example_effigo.cache.entity.User;
import com.example_effigo.cache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private  final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable long id){
        logger.info("Fetching user with ID: {}", id);
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        logger.info("Creating new user: {}", user);
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}/cache")
    public String evictCache(@PathVariable long id){
        logger.info("Evicting cache for user ID: {}", id);
        userService.evictUserFromCache(id);
        return "Cache evicted for user ID:" +id;
    }

    @DeleteMapping("/clear-all")
    public String clearCache(){
        userService.clearCache();
        return "Cache cleared";
    }

    @GetMapping("/{id}/isCached")
    public boolean isUserCached(@PathVariable long id) {
        boolean cached = userService.isUserInCache(id);
        logger.info("User with ID {} is cached: {}", id, cached);
        return cached;
    }
}
