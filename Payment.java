
abstract class Payment {

    int transactionId;
    double amount;

    // Static reference to store maximum transaction
    static Payment maxTransaction = null;

    // Constructor
    Payment(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;

        // Update maximum transaction
        if (maxTransaction == null || amount > maxTransaction.amount) {
            maxTransaction = this;
        }
    }

    // Abstract method
    abstract void processPayment();

    // Concrete method
    void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: Rs. " + amount);
    }

    // Static method to display maximum transaction
    static void displayMaxTransaction() {

        if (maxTransaction != null) {
            System.out.println("\n----- MAXIMUM TRANSACTION -----");
            maxTransaction.displayTransaction();
            maxTransaction.processPayment();
        }
    }
}

// First subclass
class CreditCardPayment extends Payment {

    CreditCardPayment(int id, double amount) {
        super(id, amount);
    }

    @Override
    void processPayment() {
        System.out.println("Payment processed using Credit Card.");
    }
}

// Second subclass
class UPIBasedPayment extends Payment {

    UPIBasedPayment(int id, double amount) {
        super(id, amount);
    }

    @Override
    void processPayment() {
        System.out.println("Payment processed using UPI.");
    }
}

// Third subclass
class NetBankingPayment extends Payment {

    NetBankingPayment(int id, double amount) {
        super(id, amount);
    }

    @Override
    void processPayment() {
        System.out.println("Payment processed using Net Banking.");
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        // Creating Credit Card Payment object
        CreditCardPayment p1 =
            new CreditCardPayment(101, 5000);

        // Creating UPI Payment object
        UPIBasedPayment p2 =
            new UPIBasedPayment(102, 2500);

        // Creating Net Banking Payment object
        NetBankingPayment p3 =
            new NetBankingPayment(103, 8000);

        // Display Credit Card transaction
        System.out.println("----- CREDIT CARD PAYMENT -----");
        p1.displayTransaction();
        p1.processPayment();

        // Display UPI transaction
        System.out.println("\n----- UPI PAYMENT -----");
        p2.displayTransaction();
        p2.processPayment();

        // Display Net Banking transaction
        System.out.println("\n----- NET BANKING PAYMENT -----");
        p3.displayTransaction();
        p3.processPayment();

        // Display transaction with maximum amount
        Payment.displayMaxTransaction();
    }
}
