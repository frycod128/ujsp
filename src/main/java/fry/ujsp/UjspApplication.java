package fry.ujsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UjspApplication extends SpringBootServletInitializer {  // 继承这个类

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UjspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(UjspApplication.class, args);
    }
}