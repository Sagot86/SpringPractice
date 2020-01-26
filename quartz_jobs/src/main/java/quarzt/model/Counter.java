package quarzt.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Counter {

    private long count;

    public void increment() {
        count++;
    }

}
