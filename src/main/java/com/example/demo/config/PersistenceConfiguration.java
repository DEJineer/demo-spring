package com.example.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

//    @Bean
//    public DataSource dataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/conference_app");
//        dataSourceBuilder.username("dej");
//        dataSourceBuilder.password("dej");
//        System.out.println("My custom dataSource has been initialized and set");
//        return dataSourceBuilder.build();
//    }
 }
