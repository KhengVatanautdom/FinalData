// Node class representing each element in the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Main class for detecting and removing loops in a linked list
public class DetectLoopInLinkedList {
    Node head;

    // Add a new node to the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Create a loop at the given position (1-based index)
    public void createLoop(int position) {
        if (position <= 0) return;

        Node loopStart = null;
        Node temp = head;
        int count = 1;

        while (temp.next != null) {
            if (count == position) {
                loopStart = temp;
            }
            temp = temp.next;
            count++;
        }

        if (loopStart != null) {
            temp.next = loopStart;
        }
    }

    // Detects if a loop exists using Floyd’s Cycle Detection Algorithm
    public boolean hasLoop() {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move by one
            fast = fast.next.next;    // Move by two

            if (slow == fast) {
                return true;          // Loop detected
            }
        }

        return false;                 // No loop
    }

    // Detects and removes a loop if it exists
    public void detectAndRemoveLoop() {
        Node slow = head, fast = head;

        // First detect the loop
        boolean loopExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        // If loop exists, remove it
        if (loopExists) {
            slow = head;

            // Special case: loop starts at head
            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            // Break the loop
            fast.next = null;
            System.out.println(" Loop detected and removed.");
        } else {
            System.out.println(" No loop found.");
        }
    }

    // Print list (stops if loop is detected)
    public void printList() {
        Node current = head;
        int count = 0;
        while (current != null && count < 100) { // Safe limit for looped lists
            System.out.print(current.data + " -> ");
            current = current.next;
            count++;
        }
        if (count == 100) {
            System.out.println("... (stopped to avoid infinite loop)");
        } else {
            System.out.println("null");
        }
    }

    // Main method to demonstrate the program
    public static void main(String[] args) {
        DetectLoopInLinkedList list = new DetectLoopInLinkedList();

        // Creating linked list
        for (int i = 1; i <= 10; i++) {
            list.append(i);
        }

        // Optionally create a loop at position 4 (node with value 4)
        list.createLoop(4);

        // Detect and remove loop
        list.detectAndRemoveLoop();

        // Print the final list after fixing
        list.printList();
    }
}
