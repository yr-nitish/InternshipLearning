package com.ateffigo.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) { };
record Address (String Line1,String city) { };

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name()
    {
        return "Nitish";
    }

    @Bean
    public int age()
    {
        return 22;
    }

    @Bean
    public Person person()
    {
        return new  Person("Ravi", 20, new Address("Hitec city","Telangana"));
    }

    @Bean
    public Person person2MethodCall()
    {
        return new Person(name(), age(), address()); //name, age
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address2)
    { //name, age, address2
        return new Person(name, age, address2); //name, age
    }

    @Bean
    public Person person4Qualifier(String name, int age,@Qualifier("address2qualifier") Address address2)
    { //name, age, address2
        return new Person(name, age, address2); //name, age
    }

    @Bean(name = "address2")
    @Qualifier("address2qualifier")
    public Address address()
    {
        return new Address("Madhapur","Hyderabad");
    }

    @Bean(name = "address3")
    @Primary
    public Address address3()
    {
        return new Address("Chargawan","Gorakhpur");
    }
}
