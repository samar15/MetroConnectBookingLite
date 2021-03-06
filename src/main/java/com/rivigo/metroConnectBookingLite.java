package com.rivigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.rivigo.repository")
@SpringBootApplication
public class metroConnectBookingLite {

    public static void main(String[] args) {
        SpringApplication.run(metroConnectBookingLite.class,args);
        

    }
}
