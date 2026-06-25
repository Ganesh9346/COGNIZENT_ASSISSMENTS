/*

EXERCISE 2: E-COMMERCE PLATFORM SEARCH FUNCTION
1. Big O Notation
Big O notation is used to measure the efficiency of an algorithm. It tells us how the running time 
of a program changes when the input size increases. It helps programmers choose better algorithms 
for handling large amounts of data.

2. Search Cases

Best Case:
The required product is found immediately. For example, the product is present at the first 
position.
Average Case:
The product is found somewhere in the middle of the collection.
Worst Case:
The product is present at the last position or is not present at all, so every element must be checked.

3. Time Complexity Comparison
Linear Search:
Best Case : O(1)
Average Case : O(n)
Worst Case : O(n)
Binary Search:
Best Case : O(1)
Average Case : O(log n)
Worst Case : O(log n)

4. Suitable Algorithm
For a small number of products, linear search works well because it is simple and does not require 
sorting. For large e-commerce platforms containing thousands of products, binary search is more 
suitable because it searches much faster. However, binary search requires the data to be sorted 
before searching.

*/
class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println("ID : " + productId);
        System.out.println("Name : " + productName);
        System.out.println("Category : " + category);
        System.out.println();
    }
}

public class Exercise2_SearchFunction {
    static Product linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                return products[i];
            }
        }
        return null;
    }

    static Product binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result =
                    products[mid].productName.compareToIgnoreCase(name);

            if (result == 0) {
                return products[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Array for Linear Search
        Product[] products1 = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Phone", "Electronics"),
                new Product(105, "Speaker", "Electronics")
        };

        System.out.println("Linear Search");

        Product p1 = linearSearch(products1, "Phone");

        if (p1 != null) {
            p1.display();
        } else {
            System.out.println("Product not found.");
        }

        // Sorted Array for Binary Search
        Product[] products2 = {
                new Product(103, "Keyboard", "Accessories"),
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(104, "Phone", "Electronics"),
                new Product(105, "Speaker", "Electronics")
        };

        System.out.println("Binary Search");

        Product p2 = binarySearch(products2, "Phone");

        if (p2 != null) {
            p2.display();
        } else {
            System.out.println("Product not found.");
        }
    }
}