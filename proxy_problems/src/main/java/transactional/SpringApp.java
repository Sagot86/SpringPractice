package transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringApp implements CommandLineRunner {

    private final Manages manages;

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        manages.doSomething();
    }
}
