package chapter05;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySortTreeTest {

    private static BinarySortTree TREE = new BinarySortTree();
    
    @BeforeClass
    public static void testAdd() {
        // create BinarySortTree
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        for (int i : arr) {
            Node node = new Node(i);
            TREE.add(node);
        }
        // midShow
        TREE.midShow();
        System.out.println();
    }
    
    @Test
    public void testFind(){
        Node node1 = TREE.find(3);
        Node node2 = TREE.find(0);
        System.out.println(node1);
        System.out.println(node2);
    }

    @Test
    public void testRemoveLeaf(){
        TREE.removeLeaf(3);
        TREE.midShow();
    }

    @Test
    public void testRemoveSingleNode(){
        TREE.removeLeaf(1);
        TREE.removeSingleChildNode(3);
        TREE.midShow();
        System.out.println(TREE);
    }
    @Test
    public void testRemoveDoubleChildNode(){
        TREE.removeDoubleChildNode(3);
        TREE.midShow();
        System.out.println(TREE);
    }
}