
import java.util.Scanner;

// User-defined exception for a full queue
class QueueOverflowException extends Exception {
    QueueOverflowException(String message) {
        super(message);
    }
}

// User-defined exception for an empty queue
class QueueUnderflowException extends Exception {
    QueueUnderflowException(String message) {
        super(message);
    }
}

class Queue {
    int arr[];
    int front, rear;
    int size;

    Queue(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    // Insert an element
    void enqueue(int element) throws QueueOverflowException {
        if (rear == size - 1) {
            throw new QueueOverflowException("Queue is Full!");
        }

        arr[++rear] = element;
        System.out.println(element + " inserted successfully.");
    }

    // Remove an element
    int dequeue() throws QueueUnderflowException {
        if (front > rear) {
            throw new QueueUnderflowException("Queue is Empty!");
        }

        int element = arr[front];
        front++;

        return element;
    }

    // Display queue elements
    void display() {
        if (front > rear) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println("Queue elements:");

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Search for an element
    int search(int element) {
        for (int i = front; i <= rear; i++) {
            if (arr[i] == element) {
                return i;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int n = sc.nextInt();

        Queue q = new Queue(n);

        int choice, element, index;

        do {
            System.out.println("\n----- QUEUE MENU -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Search");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter element: ");
                        element = sc.nextInt();
                        q.enqueue(element);
                        break;

                    case 2:
                        element = q.dequeue();
                        System.out.println("Deleted element: " + element);
                        break;

                    case 3:
                        q.display();
                        break;

                    case 4:
                        System.out.print("Enter element to search: ");
                        element = sc.nextInt();

                        index = q.search(element);

                        if (index == -1) {
                            System.out.println("Element not found.");
                        } else {
                            System.out.println("Element found at index: " + index);
                        }
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
            catch (QueueOverflowException | QueueUnderflowException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
