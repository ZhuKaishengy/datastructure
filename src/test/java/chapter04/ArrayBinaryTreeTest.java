package chapter04;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayBinaryTreeTest {

    private static ArrayBinaryTree arrayBinaryTree;

    @BeforeClass
    public static void init(){
        arrayBinaryTree = new ArrayBinaryTree();
        int[] arr = new int[]{1,2,3,4,5,6};
        arrayBinaryTree.setElements(arr);
    }
    @Test
    public void frontShow() {
        arrayBinaryTree.frontShow(0);
    }
}