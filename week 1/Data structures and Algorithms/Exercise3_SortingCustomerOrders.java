/*

EXERCISE 3: SORTING CUSTOMER ORDERS
1. Different Sorting Algorithms
Bubble Sort:
Bubble Sort repeatedly compares two adjacent elements and swaps them if they are in the wrong order. 
It is simple to understand but becomes slow when the amount of data increases.
Insertion Sort:
Insertion Sort takes one element at a time and places it in its correct position in the already 
sorted part of the array. It works well for small data sets.
Quick Sort:
Quick Sort selects a pivot element and divides the array into two parts. Elements smaller than the 
pivot are placed on one side and larger elements on the other side. The same process is repeated 
recursively.
Merge Sort:
Merge Sort divides the array into smaller parts, sorts each part separately, and then merges them 
into a single sorted array.

2. Time Complexity Comparison
Bubble Sort:
Best Case : O(n)
Average Case : O(n²)
Worst Case : O(n²)
Quick Sort:
Best Case : O(n log n)
Average Case : O(n log n)
Worst Case : O(n²)

3. Why Quick Sort is Preferred
Quick Sort is generally preferred because it performs much faster than Bubble Sort for large amounts 
of data. It reduces the number of comparisons and is widely used in real applications where 
performance is important.

*/

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println(orderId + " " +
                           customerName + " " +
                           totalPrice);
    }
}

public class Exercise3_SortingCustomerOrders {

    static void displayOrders(Order[] orders) {
        for (int i = 0; i < orders.length; i++) {
            orders[i].display();
        }
        System.out.println();
    }

    // Bubble Sort
    static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice >
                        orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    static void quickSort(Order[] orders,
                          int low,
                          int high) {

        if (low < high) {
            int p = partition(orders, low, high);

            quickSort(orders, low, p - 1);
            quickSort(orders, p + 1, high);
        }
    }

    static int partition(Order[] orders,
                         int low,
                         int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Order[] orders1 = {
            new Order(101, "Rahul", 2500),
            new Order(102, "Anjali", 7000),
            new Order(103, "Ramesh", 4000),
            new Order(104, "Priya", 1500),
            new Order(105, "Kiran", 5500)
        };

        System.out.println("Before Bubble Sort");
        displayOrders(orders1);

        bubbleSort(orders1);

        System.out.println("After Bubble Sort");
        displayOrders(orders1);

        Order[] orders2 = {
            new Order(101, "Rahul", 2500),
            new Order(102, "Anjali", 7000),
            new Order(103, "Ramesh", 4000),
            new Order(104, "Priya", 1500),
            new Order(105, "Kiran", 5500)
        };

        System.out.println("Before Quick Sort");
        displayOrders(orders2);

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("After Quick Sort");
        displayOrders(orders2);
    }
}