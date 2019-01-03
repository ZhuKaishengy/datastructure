package chapter02;

import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void isEmpty() {
        MyQueue queue = new MyQueue();
        System.out.println(queue.isEmpty());
        queue.add(1);
        System.out.println(queue.isEmpty());
    }

    @Test
    public void add() {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
    }

    @Test
    public void poll() {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        int poll1 = queue.poll();
        int poll2 = queue.poll();
        System.out.println(poll1);
        System.out.println(poll2);
        System.out.println(queue);
    }

    @Test
    public void peek() {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}