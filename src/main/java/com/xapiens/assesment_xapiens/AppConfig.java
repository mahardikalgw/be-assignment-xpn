package com.xapiens.assesment_xapiens;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.Validator;

@Configuration
@EnableWebMvc
public class AppConfig {
  
  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  public Validator validator() {
      return new LocalValidatorFactoryBean();
  }

  // @Override
  // public void addCorsMappings(CorsRegistry registry) {
  //     registry.addMapping("/**");
  // }
}
