package wcci.org.pawsclaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Paws and Claws application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class Main {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args Command-line arguments (optional).
     */
    public static void main(String[] args) {
        // Launch the Spring Boot application
        SpringApplication.run(Main.class, args);
    }
}

