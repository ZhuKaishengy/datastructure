package chapter04;

import org.junit.BeforeClass;
import org.junit.Test;

public class ThreadedBinaryTreeTest {

    private static ThreadedBinaryTree binaryTree;

    /**
     * 创建一个链式存储结构中的二叉树
     *          1
     *     2        3
     *  4    5   6     7
     */
    @BeforeClass
    public static void createBinaryTree(){
        binaryTree = new ThreadedBinaryTree();
        ThreadedTreeNode root = new ThreadedTreeNode(1);
        ThreadedTreeNode rootLChild = new ThreadedTreeNode(2);
        ThreadedTreeNode rootRChild = new ThreadedTreeNode(3);
        root.setLeftNode(rootLChild).setRightNode(rootRChild);
        // 为左节点添加节点
        rootLChild.setLeftNode(new ThreadedTreeNode(4));
        rootLChild.setRightNode(new ThreadedTreeNode(5));
        // 为右节点添加节点
        rootRChild.setLeftNode(new ThreadedTreeNode(6));
        rootRChild.setRightNode(new ThreadedTreeNode(7));
        // 将root节点添加到数中
        binaryTree.setRoot(root);
    }

    @Test
    public void test(){
        System.out.println(this.binaryTree);
    }
    @Test
    public void testFontshow(){
        this.binaryTree.frontShow();
    }

    @Test
    public void midThreadNodes(){
        this.binaryTree.midThreadNodes(binaryTree.getRoot());
        binaryTree.threadIterator();
    }

}