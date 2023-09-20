package CSD201_3;

import java.util.LinkedList;

public class MyQueue {

    LinkedList<Person> t;

    MyQueue() {
        t = new LinkedList<>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Person x) {
        t.addLast(x);
    }

    Person dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    void display() {
        for (Person x : t) {
            System.out.println(x.getSTT() + ", " + x.getName() + ", " + x.getJob());
        }
    }

}
