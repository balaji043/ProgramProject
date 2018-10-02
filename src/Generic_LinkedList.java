class List<E> {
    E data;
    List<E> next;
    List<E> prev;

    List(E data, List prev, List next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class Generic_LinkedList<E> {
    private transient List<E> first = null;
    private transient List<E> last = null;
    private transient List<E> temp = null, newNode = null;
    private transient int size, i, mid;

    Generic_LinkedList() {
        size = 0;
    }

    Generic_LinkedList(E data) {
        first = new List<>(data, null, null);
        size = 1;
    }

    void add(E data) {
        add_at_last(data);
    }

    void remove(E data) {
        del_at_end();
    }

    void add_at_beg(E data) {
        if (first == null) {
            first = new List<>(data, null, null);
            last = first;
        } else {
            newNode = new List<>(data, null, first);
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    void add_at_mid(E data) {
        if (size == 0) {
            first = new List<>(data, null, null);
            last = first;
        } else {
            i = 0;
            mid = size / 2;
            temp = first;
            while (i < mid) {
                temp = temp.next;
                i++;
            }
            newNode = new List<>(data, temp, temp.next);
            temp.next = newNode;
        }
        size++;
    }

    private void add_at_last(E data) {
        if (first == null) {
            first = new List<>(data, null, null);
            last = first;
        } else {
            newNode = new List<>(data, last, null);
            last = newNode;
        }
        temp = null;
        size++;
    }

    void del_at_beg() {
        if (first == null) {
            System.out.println("Empty List");
        } else {
            first = first.next;
            first.prev = null;
            size--;
        }
    }

    void del_at_mid() {
        if (size == 0) {
            System.out.println("Not Possible");
        } else {
            mid = size / 2;
            i = 0;
            temp = first;
            while (i < mid) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }

    private void del_at_end() {
        if (size == 0) {
            System.out.println("Not Possible");
        } else {
            last = last.prev;
            last.prev.next = null;
        }
        size--;
    }

    void reverse() {
        List<E> temp = last;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    void showAll() {
        List<E> temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
