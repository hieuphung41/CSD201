package CSD201_2;

import java.util.LinkedList;

public class MyStack {

    LinkedList<Integer> list;

    public MyStack() {
        list = new LinkedList<>();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return (list.isEmpty());
    }

    public void push(int x) {
        list.addLast(x);
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        return (list.removeLast());
    }

    public int top() {
        if (list.isEmpty()) {
            return -1;
        }
        return (list.getLast());
    }

}
