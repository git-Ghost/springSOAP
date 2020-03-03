package com.example.demo;

import com.example.demo.schemas.NumberConversion.NumberToDollars;
import com.example.demo.schemas.NumberConversion.NumberToDollarsResponse;
import com.example.demo.soapclient.SOAPConnector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;

@ComponentScan(basePackages = "com.example.demo")
@SpringBootApplication
public class SpringSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSoapApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            System.out.println("Inside Runner Method...URL --> "+soapConnector.getDefaultUri());
            NumberToDollars request = new NumberToDollars();
            request.setDNum(new BigDecimal(60));
            NumberToDollarsResponse response = (NumberToDollarsResponse) soapConnector.callWebService(soapConnector.getDefaultUri(), request);
            System.out.println("================================\n" + response.getNumberToDollarsResult());
        };
    }
}
