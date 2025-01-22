package com.ateffigo.learn_spring_framework.examples.c1;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] { 1,2,3,4,5};
    }
}
