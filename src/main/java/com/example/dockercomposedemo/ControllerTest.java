package com.example.dockercomposedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping(value = "/api/test")
public class ControllerTest {

    @Value("${a.bcDe}")
    private String value;

    /**
     * set in compose > set in container
     */
    @GetMapping(value = "/env")
    public String testEnv() {
        System.out.println(value);
        String env = System.getenv().toString();
        System.out.println("=================");
        System.out.println(env);
        System.out.println("=================");
        Properties property = System.getProperties();
        property.list(System.out);
        System.out.println("=================");
        System.out.println(property);
        return value;
    }
}
