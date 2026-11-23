
import java.util.Scanner;

class ElectricityConsumer {
    int consumerId;
    String consumerName;
    double unitsConsumed;
    double ratePerUnit;
    String consumerType;

    // Parameterized constructor
    ElectricityConsumer(int id, String name, double units,
                        double rate, String type) {
        consumerId = id;
        consumerName = name;
        unitsConsumed = units;
        ratePerUnit = rate;
        consumerType = type;
    }

    // First overloaded method: Calculate original bill
    double calculateBill() {
        double bill = unitsConsumed * ratePerUnit;

        if (consumerType.equalsIgnoreCase("Domestic")) {
            bill = Math.max(bill, 100);
        } else if (consumerType.equalsIgnoreCase("NonDomestic")) {
            bill = Math.max(bill, 1000);
        }

        return bill;
    }

    // Second overloaded method: Calculate revised bill
    double calculateBill(double surchargePercentage) {
        double bill = calculateBill();

        double revisedBill = bill + (bill * surchargePercentage / 100);

        return revisedBill;
    }

    // Display consumer details and bills
    void displayDetails(double surchargePercentage) {
        System.out.println("\nConsumer ID: " + consumerId);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Rate Per Unit: " + ratePerUnit);
        System.out.println("Consumer Type: " + consumerType);

        System.out.println("Original Bill: " + calculateBill());

        System.out.println("Revised Bill: "
                           + calculateBill(surchargePercentage));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of consumers: ");
        int n = sc.nextInt();

        ElectricityConsumer[] consumers =
            new ElectricityConsumer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Consumer " + (i + 1));

            System.out.print("Enter Consumer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Consumer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Units Consumed: ");
            double units = sc.nextDouble();

            System.out.print("Enter Rate Per Unit: ");
            double rate = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Consumer Type (Domestic/NonDomestic): ");
            String type = sc.nextLine();

            consumers[i] = new ElectricityConsumer(
                id, name, units, rate, type
            );
        }

        System.out.print("\nEnter surcharge percentage: ");
        double surcharge = sc.nextDouble();

        System.out.println("\n===== ELECTRICITY BILL DETAILS =====");

        for (int i = 0; i < n; i++) {
            consumers[i].displayDetails(surcharge);
        }

        sc.close();
    }
}
