// ExpenseRequest Class
class ExpenseRequest {
    public double amount;
    public String purpose;

    public ExpenseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }
}

// Approver Abstract Class
abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approve(ExpenseRequest request);
}

// Concrete Approvers
class Manager extends Approver {
    public void approve(ExpenseRequest request) {
        if (request.amount < 1000) {
            System.out.println("Manager approved expense for " + request.purpose);
        } else if (nextApprover != null) {
            nextApprover.approve(request);
        }
    }
}

class Director extends Approver {
    public void approve(ExpenseRequest request) {
        if (request.amount < 5000) {
            System.out.println("Director approved expense for " + request.purpose);
        } else if (nextApprover != null) {
            nextApprover.approve(request);
        }
    }
}

// Main Class
public class ExpenseApprovalSystem {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();

        manager.setNextApprover(director);

        ExpenseRequest request = new ExpenseRequest(2000, "Conference Trip");
        manager.approve(request);
    }
}
