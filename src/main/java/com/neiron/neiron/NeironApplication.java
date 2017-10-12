package com.neiron.neiron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeironApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeironApplication.class, args);
    }
}
//
//    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        dataSource.setDriverClass(org.h2.Driver.class);
//        dataSource.setUsername("sa");
//        dataSource.setUrl("jdbc:h2:mem");
//        dataSource.setPassword("");
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//        System.out.println("Creating tables");
//        jdbcTemplate.execute("drop table customers if exists");
//        jdbcTemplate.execute("create table customers(" +
//        "id serial, first_name varchar(255), last_name varchar(255))");