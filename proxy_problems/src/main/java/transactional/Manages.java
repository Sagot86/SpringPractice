package transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Manages.
 *
 * @author Igor_Orlov
 */
@Component
@RequiredArgsConstructor
public class Manages {

    private final ServiceWithTransactions serviceWithTransactions;

    public void doSomething() {
        serviceWithTransactions.makePayment();
        System.out.println("Blablabla");
    }

}
