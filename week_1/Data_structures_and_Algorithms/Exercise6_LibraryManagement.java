/*

EXERCISE 6: LIBRARY MANAGEMENT SYSTEM
1. Search Algorithms
Linear Search:
Linear search checks each element one by one until the required element is found or the entire list 
is traversed. It is simple to implement and works on both sorted and unsorted data.
Binary Search:
Binary search repeatedly divides the search space into two halves. It compares the middle element 
with the target value and continues the search in only one half of the array. Binary search works 
only on sorted data.

2. Time Complexity Comparison
Linear Search:
Best Case : O(1)
Average Case : O(n)
Worst Case : O(n)
Binary Search:
Best Case : O(1)
Average Case : O(log n)
Worst Case : O(log n)

3. When to Use Each Algorithm
Linear search is suitable for small data sets or when the data is not sorted.
Binary search is suitable for large data sets that are already sorted because it performs the search 
much faster by reducing the search space in every step.
*/

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println();
    }
}

public class Exercise6_LibraryManagement {

    // Linear Search
    static Book linearSearch(Book[] books, String title) {

        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }

    // Binary Search
    static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            }
            else if (result < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Unsorted array for Linear Search
        Book[] books1 = {
            new Book(101, "Java", "James Gosling"),
            new Book(102, "Python", "Guido van Rossum"),
            new Book(103, "Data Structures", "Mark Allen"),
            new Book(104, "C Programming", "Dennis Ritchie"),
            new Book(105, "Algorithms", "Robert Sedgewick")
        };

        System.out.println("Linear Search Result");

        Book b1 = linearSearch(books1, "Python");

        if (b1 != null) {
            b1.display();
        } else {
            System.out.println("Book Not Found.");
        }

        // Sorted array for Binary Search
        Book[] books2 = {
            new Book(105, "Algorithms", "Robert Sedgewick"),
            new Book(104, "C Programming", "Dennis Ritchie"),
            new Book(103, "Data Structures", "Mark Allen"),
            new Book(101, "Java", "James Gosling"),
            new Book(102, "Python", "Guido van Rossum")
        };

        System.out.println("Binary Search Result");

        Book b2 = binarySearch(books2, "Python");

        if (b2 != null) {
            b2.display();
        } else {
            System.out.println("Book Not Found.");
        }
    }
}