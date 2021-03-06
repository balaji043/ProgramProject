

public class My_LinkedList {
    public static void main(String[] a) {
        GenericList();
        NormalList();
    }

    private static void NormalList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert_At_End(10);
        myLinkedList.insert_At_End(20);
        myLinkedList.insert_At_End(30);
        myLinkedList.insert_After(25, 20);
        myLinkedList.insert_After(15, 10);
        myLinkedList.insert_At_End(40);
        myLinkedList.insert_At_Begin(5);
        myLinkedList.insert_At_Begin(10);
        myLinkedList.insert_Before(35, 30);
        myLinkedList.Display();
        myLinkedList.delete_After(20);
        myLinkedList.Display();
        System.out.println(myLinkedList.size());
    }

    private static void GenericList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>(5);
        list.add(6);
        list.add_at_beg(1);
        list.add_at_mid(3);
        list.add(7);
        list.add_at_beg(0);
        list.add_at_mid(2);
        list.showAll();
        list.deleteAtBeg();
        list.showAll();
        list.deleteAtMid();
        list.showAll();
        list.remove();
        list.showAll();
        list.reverse();
        System.out.println(list.size());
        GenericLinkedList<String> a = new GenericLinkedList<>();
        System.out.println(a.size());
    }
}
