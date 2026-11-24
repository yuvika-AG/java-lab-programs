
import java.util.Scanner;

class FoodOrder {
    int orderId;
    String customerName;
    double orderAmount;

    static int dineInCount = 0;
    static int takeAwayCount = 0;
    static int onlineCount = 0;

    FoodOrder(int id, String name, double amount) {
        orderId = id;
        customerName = name;
        orderAmount = amount;
    }

    void calculateBill() {
        System.out.println("Calculating bill...");
    }

    static void displayCount() {
        System.out.println("\n----- ORDER COUNTS -----");
        System.out.println("Dine-In Orders: " + dineInCount);
        System.out.println("Takeaway Orders: " + takeAwayCount);
        System.out.println("Online Orders: " + onlineCount);
    }
}

class DineInOrder extends FoodOrder {

    DineInOrder(int id, String name, double amount) {
        super(id, name, amount);
        dineInCount++;
    }

    @Override
    void calculateBill() {
        double bill = orderAmount + (orderAmount * 0.05);

        System.out.println("\nDine-In Order");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Original Amount: " + orderAmount);
        System.out.println("Service Charge (5%): " + (orderAmount * 0.05));
        System.out.println("Final Bill: " + bill);
    }
}

class TakeAwayOrder extends FoodOrder {

    TakeAwayOrder(int id, String name, double amount) {
        super(id, name, amount);
        takeAwayCount++;
    }

    @Override
    void calculateBill() {
        double discount = orderAmount * 0.02;
        double bill = orderAmount - discount;

        System.out.println("\nTakeaway Order");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Original Amount: " + orderAmount);
        System.out.println("Discount (2%): " + discount);
        System.out.println("Final Bill: " + bill);
    }
}

class OnlineOrder extends FoodOrder {

    OnlineOrder(int id, String name, double amount) {
        super(id, name, amount);
        onlineCount++;
    }

    @Override
    void calculateBill() {
        double charge = orderAmount * 0.10;
        double bill = orderAmount + charge;

        System.out.println("\nOnline Order");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Original Amount: " + orderAmount);
        System.out.println("Platform Charge (10%): " + charge);
        System.out.println("Final Bill: " + bill);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FoodOrder f;

        System.out.println("Enter Dine-In Order Details:");
        System.out.print("Order ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Order Amount: ");
        double amount = sc.nextDouble();

        f = new DineInOrder(id, name, amount);
        f.calculateBill();

        System.out.println("\nEnter Takeaway Order Details:");
        System.out.print("Order ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        name = sc.nextLine();

        System.out.print("Order Amount: ");
        amount = sc.nextDouble();

        f = new TakeAwayOrder(id, name, amount);
        f.calculateBill();

        System.out.println("\nEnter Online Order Details:");
        System.out.print("Order ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        name = sc.nextLine();

        System.out.print("Order Amount: ");
        amount = sc.nextDouble();

        f = new OnlineOrder(id, name, amount);
        f.calculateBill();

        FoodOrder.displayCount();

        sc.close();
    }
}
