package transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentComponent {

    private final ServiceWithTransactions serviceWithTransactions;

    void init() {
        serviceWithTransactions.makePayment();
    }
}
