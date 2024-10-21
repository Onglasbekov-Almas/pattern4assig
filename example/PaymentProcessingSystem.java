// PaymentStrategy Interface
interface PaymentStrategy {
    void processPayment(double amount);
}

// CreditCardPayment
class CreditCardPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount);
    }
}

// PayPalPayment
class PayPalPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }
}

// CryptoPayment
class CryptoPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrency payment of " + amount);
    }
}

// ShoppingCart
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

// Main class
public class PaymentProcessingSystem {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);

        cart.setPaymentStrategy(new CryptoPayment());
        cart.checkout(300);
    }
}
