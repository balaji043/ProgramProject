import java.util.Stack;

public class Stack_And_Queue {
    public static void main(String[] args) {
        new Queue_Using_Stacks();
    }
}

class Queue_Using_Stacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    Queue_Using_Stacks() {
        Enqueue(10);
        Enqueue(11);
        Enqueue(12);
        System.out.println(Dequeue());
    }

    private void Enqueue(int n) {
        stack1.push(n);
    }

    private String Dequeue() {
        if (stack1.size() == 0 && stack2.size() == 0)
            return "Queue is empty";
        while (!stack1.empty()) {
            int p = stack1.pop();
            stack2.push(p);
        }
        return "" + stack2.pop();
    }
}
