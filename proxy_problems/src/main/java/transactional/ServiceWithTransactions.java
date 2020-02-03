package transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ServiceWithTransactions {

    @Lazy
    @Autowired
    private ServiceWithTransactions self;

        public void makePayment() {
        pay();
        self.makeNotification();
    }

    public void pay() {
        System.out.println("Payment completed");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void makeNotification() {
        System.out.println("Notification was made");
    }

}
