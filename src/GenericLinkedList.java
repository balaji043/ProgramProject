package common;

class NodeElement<E> {
    E data;
    NodeElement<E> next;
    NodeElement<E> prev;

    NodeElement(E data, NodeElement<E> prev, NodeElement<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class GenericLinkedList<E> {
    private NodeElement<E> first = null;
    private NodeElement<E> last = null;
    private NodeElement<E> temp = null;
    private NodeElement<E> newNode = null;
    private int size, i, mid;

    GenericLinkedList() {
        size = 0;
    }

    GenericLinkedList(E data) {
        first = new NodeElement<E>(data, null, null);
        last = first;
        size = 1;
    }

    void add(E data) {
        add_at_last(data);
    }

    void remove() {
        del_at_end();
    }

    void add_at_beg(E data) {
        if (first == null) {
            first = new NodeElement<E>(data, null, null);
            last = first;
        } else {
            newNode = new NodeElement<E>(data, null, first);
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    void add_at_mid(E data) {
        if (size == 0) {
            first = new NodeElement<E>(data, null, null);
            last = first;
        } else {
            i = 1;
            mid = size / 2 + (size % 2);
            temp = first;
            for (i = 1; i < mid; i++) {
                temp = temp.next;
            }
            if (temp.next != null && temp.prev != null) {
                newNode = new NodeElement<E>(data, temp.prev, temp);
                temp.prev.next = newNode;
                temp.prev = newNode;
            } else if (temp.prev != null) {
                newNode = new NodeElement<E>(data, temp.prev, temp);
                newNode.prev.next = newNode;
            } else {
                newNode = new NodeElement<E>(data, temp, temp.next);
                temp.next = newNode;
            }
        }
        size++;
    }

    private void add_at_last(E data) {
        if (first == null) {
            first = new NodeElement<E>(data, null, null);
            last = first;
        } else {
            newNode = new NodeElement<E>(data, last, null);
            last.next = newNode;
            last = newNode;
        }
        temp = null;
        size++;
    }

    void deleteAtBeg() {
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return;
        }
        if (first == null) {
            System.out.println("Empty List");
        } else {
            first = first.next;
            first.prev = null;
            size--;
        }
    }

    void deleteAtMid() {
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return;
        }
        if (size == 0) {
            System.out.println("Not Possible");
        } else {
            mid = size / 2 + size % 2;
            i = 0;
            temp = first;
            for (i = 1; i < mid; i++) temp = temp.next;
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }

    private void del_at_end() {
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return;
        }
        if (size == 0) {
            System.out.println("Not Possible");
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    void reverse() {
        temp = last;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    void showAll() {
        temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    Object getLast() {
        return last.data;
    }

    Object getFirst() {
        return first.data;
    }
}
