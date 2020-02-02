package transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceWithTransactions {

    void makePayment() {
        pay();
        makeNotification();
    }

    void pay() {
        System.out.println("Payment completed");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void makeNotification() {
        System.out.println("Notification was made");
    }

}
