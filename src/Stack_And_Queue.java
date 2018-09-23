import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_And_Queue {
    public static void main(String[] args) {
        new Queue_Using_Stacks();
        new Stack_Using_Queues();
    }
}

class Queue_Using_Stacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    Queue_Using_Stacks() {
        Enqueue(1);
        Enqueue(2);
        Enqueue(3);
        Dequeue();
        Dequeue();
        Dequeue();
        Dequeue();
    }

    private void Enqueue(int n) {
        System.out.println("Enqueue : " + n);
        stack1.push(n);
    }

    private void Dequeue() {
        String a;
        if (stack1.size() == 0 && stack2.size() == 0)
            a = "Queue is empty";
        else {
            while (!stack1.empty()) {
                int p = stack1.pop();
                stack2.push(p);
            }
            a = "Dequeue : " + stack2.pop();
        }
        System.out.println(a);
    }
}

class Stack_Using_Queues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    Stack_Using_Queues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        push(1);
        push(2);
        push(3);
        pop();
        pop();
        pop();
        pop();
    }

    private void push(int data) {
        System.out.println("push : " + data);
        queue1.add(data);
    }

    private void pop() {
        if (queue1.size() < 1) {
            System.out.println("Nothing to pop");
            return;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        System.out.println("pop  : " + queue1.remove());
        queue1 = queue2;
        queue2 = new LinkedList<>();
    }
}
