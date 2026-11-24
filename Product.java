
import java.util.Scanner;

class Product {

    int productId;
    String productName;
    String category;
    double price;

    static int count = 0;

    // Parameterized constructor
    Product(int id, String name, String cat, double p) {
        productId = id;
        productName = name;
        category = cat;
        price = p;

        count++;
    }

    // Overriding toString()
    public String toString() {
        return "Product ID: " + productId +
               "\nProduct Name: " + productName +
               "\nCategory: " + category +
               "\nPrice: Rs. " + price;
    }

    // Method accepting an object as argument
    void displayProduct(Product p) {
        System.out.println(p);
    }

    // Method returning a Product object
    Product getProduct() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter details of another product:");

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String cat = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product p = new Product(id, name, cat, price);

        return p;
    }

    // Static method to display total objects
    static void displayCount() {
        System.out.println("\nTotal Product Objects Created: " + count);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating first Product object
        System.out.println("Enter details of first product:");

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product p1 = new Product(id, name, category, price);

        // Passing object as argument
        System.out.println("\nDisplaying product using displayProduct():");
        p1.displayProduct(p1);

        // Receiving an object returned by getProduct()
        Product p2 = p1.getProduct();

        // Displaying returned object using toString()
        System.out.println("\nDisplaying returned product:");
        System.out.println(p2.toString());

        // Displaying total number of objects
        Product.displayCount();

        sc.close();
    }
}
