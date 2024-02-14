package com.github.thecooldrop.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class TodolistApplicationTests {

    @Container
    private static PostgreSQLContainer postgresContainer = new PostgreSQLContainer(DockerImageName.parse("postgres:16.1"))
            .withDatabaseName("todolist")
            .withUsername("admin")
            .withPassword("admin");

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
    }


    @Test
    void contextLoads() {
    }

}