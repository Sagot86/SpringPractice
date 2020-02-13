package quarzt.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CompOne {

    Config config = new Config();

    class Config {
        @Bean
        public Configurer getConf() {
            return new ConfOne();
        }
    }

}
