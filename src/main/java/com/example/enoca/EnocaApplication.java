package com.example.enoca;

import com.example.enoca.dto.CustomerRequest;
import com.example.enoca.dto.CustomerResponse;
import com.example.enoca.entity.Customer;
import com.example.enoca.mapper.CustomerMapper;
import com.example.enoca.mapper.CustomerMapperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnocaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnocaApplication.class, args);
    }
}
