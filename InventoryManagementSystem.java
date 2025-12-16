import java.util.Scanner;
import java.util.ArrayList;

class Inventory {
    int productID;
    String productName;
    double productPrice;
    int productQuantity;

    Inventory(int productID, String productName, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    double getInventoryValue() {
        return productPrice * productQuantity;
    }

    boolean isLowStock() {
        return productQuantity < 10;
    }
}

public class InventoryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Inventory> inventory = new ArrayList<>();

    public static void main(String args[]) {
        while (true) {
            System.out.println("\n---Inventory Management System---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Stock");
            System.out.println("3. Display All Products");
            System.out.println("4. Low Stock");
            System.out.println("5. Total Inventory Value");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: updateProduct(); break;
                case 3: displayAllProducts(); break;
                case 4: lowStockAlert(); break;
                case 5: totalInventoryValue(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int productID = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String productName = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double productPrice = sc.nextDouble();

        System.out.print("Enter Product Quantity: ");
        int productQuantity = sc.nextInt();

        inventory.add(new Inventory(productID, productName, productPrice, productQuantity));
        System.out.println("Product added successfully!");
    }

    static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int productId = sc.nextInt();

        for (Inventory p : inventory) {
            if (p.productID == productId) {
                System.out.print("Enter updated quantity: ");
                p.productQuantity = sc.nextInt();
                System.out.println("Product quantity updated successfully!");
                return;
            }
        }
        System.out.println("Product not found");
    }

    static void displayAllProducts() {
        System.out.println("\nID Name Price Qty Value");
        for (Inventory p : inventory) {
            System.out.println(
                p.productID + " " +
                p.productName + " " +
                p.productPrice + " " +
                p.productQuantity + " " +
                p.getInventoryValue()
            );
        }
    }

    static void lowStockAlert() {
        System.out.println("\n--Low Stock Products (<10)--");
        for (Inventory p : inventory) {
            if (p.isLowStock()) {
                System.out.println(p.productID + " " + p.productName + " " + p.productQuantity);
            }
        }
    }

    static void totalInventoryValue() {
        double totalValue = 0;
        for (Inventory p : inventory) {
            totalValue += p.getInventoryValue();
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }
}

