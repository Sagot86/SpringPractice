package bean.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class BeanScopesApp {


    public static final String INSTANCE_ID = UUID.randomUUID().toString();

    public static void main(String[] args) {
        SpringApplication.run(BeanScopesApp.class, args);
        log.info("Instance ID: {}", INSTANCE_ID);
    }

}
