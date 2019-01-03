package chapter02;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLoopNodeTest {

    @Test
    public void after() {
        DoubleLoopNode root = new DoubleLoopNode(0);
        DoubleLoopNode node1 = new DoubleLoopNode(1);
        DoubleLoopNode node2 = new DoubleLoopNode(2);
        root.after(node1);
        node1.after(node2);
        System.out.println(root.getPre().getData());
        System.out.println(root.getData());
        System.out.println(root.getNext().getData());
    }
}