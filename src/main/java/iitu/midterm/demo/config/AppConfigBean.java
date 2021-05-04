package iitu.midterm.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@Configuration
@ComponentScan("iitu.midterm.demo")
@PropertySource("/application.properties")
@EnableJpaRepositories(basePackages = "iitu.midterm.demo.repositories")
public class AppConfigBean {

    @Bean
    public Scanner getBeanScanner() {
        return new Scanner(System.in);
    }
}
