package chapter04;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeTest {


    private static BinaryTree binaryTree;

    /**
     * 创建一个链式存储结构中的二叉树
     *          1
     *     2        3
     *  4    5   6     7
     */
    @BeforeClass
    public static void createBinaryTree(){
        binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode rootLChild = new TreeNode(2);
        TreeNode rootRChild = new TreeNode(3);
        root.setLNode(rootLChild).setRNode(rootRChild);
        // 为左节点添加节点
        rootLChild.setLNode(new TreeNode(4));
        rootLChild.setRNode(new TreeNode(5));
        // 为右节点添加节点
        rootRChild.setLNode(new TreeNode(6));
        rootRChild.setRNode(new TreeNode(7));
        // 将root节点添加到数中
        binaryTree.setRoot(root);
    }

    /**
     * 1 2 4 5 3 6 7
     */
    @Test
    public void testFontShow(){
        binaryTree.fontShow();
    }

    /**
     * 4 2 5 1 6 3 7
     */
    @Test
    public void testMidShow(){
        binaryTree.midShow();
    }

    /**
     * 4 5 2 6 7 3 1
     */
    @Test
    public void testForwardShow(){
        binaryTree.forwardShow();
    }

    @Test
    public void testFrontSearch(){
        TreeNode treeNode1 = binaryTree.fontSearch(7);
        TreeNode treeNode2 = binaryTree.fontSearch(5);
        TreeNode treeNode3 = binaryTree.fontSearch(8);
        System.out.println(treeNode1);
        System.out.println(treeNode2);
        System.out.println(treeNode3);
        TreeNode treeNode4 = binaryTree.midSearch(7);
        TreeNode treeNode5 = binaryTree.midSearch(5);
        TreeNode treeNode6 = binaryTree.midSearch(8);
        System.out.println(treeNode4);
        System.out.println(treeNode5);
        System.out.println(treeNode6);
        TreeNode treeNode7 = binaryTree.forwardSearch(7);
        TreeNode treeNode8 = binaryTree.forwardSearch(5);
        TreeNode treeNode9 = binaryTree.forwardSearch(8);
        System.out.println(treeNode7);
        System.out.println(treeNode8);
        System.out.println(treeNode9);
    }

    @Test
    public void testDelSubTree(){
        int ele = 2;
        binaryTree.delSubTree(ele);
        System.out.println(binaryTree);
    }

}