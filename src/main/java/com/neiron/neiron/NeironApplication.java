package com.neiron.neiron;

import com.neiron.neiron.controllers.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class NeironApplication {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public static void main(String[] args) {

        SpringApplication.run(NeironApplication.class, args);
    }
    @RequestMapping("/test")
    String index() {
        logger.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!INDEX");
        return "index";
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