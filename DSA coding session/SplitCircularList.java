import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SplitCircularList {

    static Node head;

    
    public static void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    
    public static void splitList() {
        if (head == null || head.next == head) {
            System.out.println("Cannot split: List has less than 2 nodes.");
            return;
        }

        Node slow = head, fast = head;

        
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }

        
        if (fast.next.next == head)
            fast = fast.next;

        Node head1 = head;
        Node head2 = slow.next;

        
        slow.next = head1;
        fast.next = head2;

        System.out.print("First Circular List: ");
        printCircularList(head1);

        System.out.print("\nSecond Circular List: ");
        printCircularList(head2);
    }

    
    public static void printCircularList(Node head) {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("List must have at least one node.");
            return;
        }

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            insert(val);
        }

        // Split and display both halves
        splitList();
    }
}