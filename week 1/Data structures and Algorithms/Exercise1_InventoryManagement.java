/* 

EXERCISE 1: INVENTORY MANAGEMENT SYSTEM
1. Why are data structures and algorithms important?
In an inventory system, there may be thousands of products. Data structures help in storing the 
product details in an organized way, and algorithms help in performing operations like searching, 
updating, and deleting products quickly. Using suitable data structures improves the overall 
performance of the system.

2. Suitable Data Structures
ArrayList can be used to store products in sequence and is easy to traverse. HashMap is more 
efficient because products can be accessed directly using the product ID as the key.

3. Time Complexity Analysis
Add Product : O(1)
Update Product : O(1)
Delete Product : O(1)

4. Optimization
Using HashMap reduces the time required to find a product because it avoids searching through the 
entire collection. Therefore, operations become faster even when the inventory size increases.


*/

import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("Product ID : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price : " + price);
        System.out.println();
    }
}

public class Exercise1_InventoryManagement {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product Added.");
    }

    static void updateProduct(int id, int qty, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = qty;
            p.price = price;
            System.out.println("Product Updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void deleteProduct(int id) {
        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product Deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void displayProducts() {
        for (Product p : inventory.values()) {
            p.display();
        }
    }

    public static void main(String[] args) {

        addProduct(new Product(101, "Laptop", 10, 50000));
        addProduct(new Product(102, "Mouse", 20, 500));
        addProduct(new Product(103, "Keyboard", 15, 1000));

        System.out.println("\nInventory After Adding Products");
        displayProducts();

        updateProduct(102, 25, 600);

        System.out.println("\nInventory After Updating Product");
        displayProducts();

        deleteProduct(103);

        System.out.println("\nInventory After Deleting Product");
        displayProducts();
    }
}
