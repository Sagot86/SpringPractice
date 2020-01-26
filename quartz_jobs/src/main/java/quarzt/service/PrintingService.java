package quarzt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quarzt.model.Counter;

@Service
@RequiredArgsConstructor
public class PrintingService {

    private final Counter counter;

    public void printCount(String pre, String post) {
        System.out.println(pre + " " + counter.getCount() + " " + post);
    }

    public void increment() {
        counter.increment();
    }

}
