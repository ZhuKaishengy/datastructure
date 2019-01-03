package chapter02;

import org.junit.Test;

public class MyStackTest {

    @Test
    public void isEmpty() {
        MyStack stack = new MyStack();
        Boolean empty = stack.isEmpty();
        System.out.println(empty);
        stack.push(1);
        System.out.println(stack.isEmpty());
    }

    @Test
    public void push() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
    }

    @Test
    public void pop() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }

    @Test
    public void peek() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int peek1 = stack.peek();
        int peek2 = stack.peek();
        System.out.println(peek1);
        System.out.println(peek2);
        System.out.println(stack);
    }
}