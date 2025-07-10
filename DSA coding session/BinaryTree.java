import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class CustomQueue {
    private Node[] arr;
    private int front, rear, size;

    CustomQueue(int capacity) {
        arr = new Node[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(Node node) {
        if (size == arr.length) {
            System.out.println("Queue is full");
            return;
        }
        arr[rear++] = node;
        size++;
    }

    Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node temp = arr[front++];
        size--;
        return temp;
    }
}

public class BinaryTree {

    static Node root;

    
    public static void insert(int val) {
        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
            return;
        }

        CustomQueue queue = new CustomQueue(100); // assuming max 100 nodes
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();

            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                queue.enqueue(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                queue.enqueue(temp.right);
            }
        }
    }

    public static void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            insert(val);
        }

        System.out.print("Inorder Traversal of Tree: ");
        inorder(root);
    }
}
