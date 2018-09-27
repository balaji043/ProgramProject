public class My_LinkedList {

    private static Node head = null, last = null;

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

    private static void insert_At_Begin(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    private static void Display() {
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        insert_At_End(10);
        insert_At_End(20);
        insert_At_End(30);
        Display();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}