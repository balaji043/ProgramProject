class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class My_LinkedList {

    private static Node head = null, last = null;

    private static void insert_At_Begin(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    private static void insert_At_End(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            last = head;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    private static void insert_After(int data, int after) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node currentNode = head;
        while (currentNode.data != after) currentNode = currentNode.next;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    private static void insert_Before(int data, int after) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node currentNode = head;
            while (currentNode.next.data != after) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    private static void delete(int data) {
        Node currentNode = head;
        while (currentNode.next.data != data) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }

    private static void delete_Last() {
        Node currentNode = head;
        while (currentNode.next.next != null) currentNode = currentNode.next;
        currentNode.next = null;
        last = currentNode;
    }

    private static void delete_After(int after) {
        Node currentNode = head;
        while (currentNode.next.data != after) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }

    private static void delete_Befor(int after) {

    }

    private static int size() {
        int s = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            s++;
        }
        return s;
    }

    private static void Display() {
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print("-->");
            else System.out.println("--/0");
            temp = temp.next;
        }
        System.out.println();
    }

    private static void reverse(Node temp) {
        if (temp == null) {
            return;
        }
        reverse(temp.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        insert_At_End(10);
        insert_At_End(20);
        insert_At_End(30);
        insert_After(25, 20);
        insert_After(15, 10);
        insert_At_End(40);
        insert_At_Begin(5);
        insert_Before(35, 30);
        Display();
        delete_After(20);
        Display();
        reverse(head);
        System.out.println(size());
    }
}
