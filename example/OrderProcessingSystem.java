// State Interface
interface State {
    void handle();
}

// PaidState
class PaidState implements State {
    public void handle() {
        System.out.println("The order is now paid.");
    }
}

// Order Class
class Order {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void proceed() {
        state.handle();
    }
}

// Main class
public class OrderProcessingSystem {
    public static void main(String[] args) {
        Order order = new Order();

        order.setState(new PaidState());
        order.proceed();  // Output: "The order is now paid."
    }
}
