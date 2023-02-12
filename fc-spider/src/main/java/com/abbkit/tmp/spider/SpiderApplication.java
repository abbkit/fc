package com.abbkit.tmp.spider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
//@Import({ SomeConfiguration.class, AnotherConfiguration.class })
@EnableScheduling
@ComponentScan("com.abbkit.tmp.spider")
@MapperScan("com.abbkit.tmp.spider.mapper")
public class SpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
    }

}
