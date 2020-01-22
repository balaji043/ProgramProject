package java;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {

    private static Node head = null, last = null;

    void insert_At_Begin(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    void insert_At_End(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            last = head;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    void insert_After(int data, int after) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node currentNode = head;
        while (currentNode.data != after) currentNode = currentNode.next;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    void insert_Before(int data, int after) {
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

    void delete(int data) {
        Node currentNode = head;
        while (currentNode.next.data != data) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }

    void delete_Last() {
        Node currentNode = head;
        while (currentNode.next.next != null) currentNode = currentNode.next;
        currentNode.next = null;
        last = currentNode;
    }

    void delete_After(int after) {
        Node currentNode = head;
        while (currentNode.next.data != after) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }

    void delete_Befor(int after) {

    }

    int size() {
        int s = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            s++;
        }
        return s;
    }

    void Display() {
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

}

