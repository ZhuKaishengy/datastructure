package chapter02;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoopNodeTest {

    @Test
    public void after() {
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);
        n1.after(n2);
        n2.after(n3);
        n3.after(n4);
        System.out.println(n1.getNext());
        System.out.println(n1.getNext().getNext());
        System.out.println(n1.getNext().getNext().getNext());
        System.out.println(n1.getNext().getNext().getNext().getNext());
    }
}