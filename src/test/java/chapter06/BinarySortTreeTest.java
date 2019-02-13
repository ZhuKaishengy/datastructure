package chapter06;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySortTreeTest {

    private static BinarySortTree TREE = new BinarySortTree();

    @BeforeClass
    public static void testAdd() {
        // create BinarySortTree
//        int[] arr = new int[]{2,1,4,3,5,6};
//        int[] arr = new int[]{8,9,6,7,5,4};
        int[] arr = new int[]{8,9,5,6,4,7};
        for (int i : arr) {
            Node node = new Node(i);
            TREE.add(node);
        }
        // midShow
        TREE.midShow();
        System.out.println();
    }
    
    @Test
    public void testHeight(){
        System.out.println(TREE);
        int i = TREE.root.leftHeight();
        System.out.println(i);
        int i1 = TREE.root.rightHeight();
        System.out.println(i1);
    }

}