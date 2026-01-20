package dev.sumit.bank_app;

import dev.sumit.bank_app.fileManagement.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class BankingApp {

    public static void main(String[] args) {
        SpringApplication.run(BankingApp.class, args);
    }

}
