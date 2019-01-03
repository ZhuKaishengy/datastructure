package chapter02;

import org.junit.Test;

public class NodeTest {

    @Test
    public void test1(){
       Node root = new Node(0);
       Node node1 = new Node(1);
       Node node2 = new Node(2);
       Node node3 = new Node(3);
       root.append(node1).append(node2).append(node3);
//       System.out.println(root);
//       System.out.println(node1);
//       System.out.println(node2.isLast()); // false
//       System.out.println(node3.isLast()); // true
//       System.out.println(root.contains(0)); // true
//       System.out.println(node1.contains(3));// true
//       System.out.println(node2.contains(1));// false
//        System.out.println(node1.remove(3));
        Node node4 = new Node(4);
        root.insert(node4);
        System.out.println(root);
    }
}
