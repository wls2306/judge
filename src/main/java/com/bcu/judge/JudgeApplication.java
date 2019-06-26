package com.bcu.judge;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class JudgeApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
  {
      return application.sources(JudgeApplication.class);
  }

    public static void main(String[] args) {
        SpringApplication.run(JudgeApplication.class, args);
    }
}
