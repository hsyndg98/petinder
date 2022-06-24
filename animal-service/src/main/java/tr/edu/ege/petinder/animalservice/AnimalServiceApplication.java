package tr.edu.ege.petinder.animalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AnimalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalServiceApplication.class, args);
    }

}
