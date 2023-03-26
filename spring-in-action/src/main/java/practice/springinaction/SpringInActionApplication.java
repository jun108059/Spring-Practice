package practice.springinaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class SpringInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringInActionApplication.class, args);
    }

}
