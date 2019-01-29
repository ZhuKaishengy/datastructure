package chapter04;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 线索二叉树
 * 线索化二叉树一个节点的前一个节点：前驱节点
 * 线索化二叉树一个节点的后一个节点：后继节点
 */
@Data
@Accessors(chain = true)
@ToString
public class ThreadedBinaryTree {

    private ThreadedTreeNode root;

    /**
     * 记录上一个节点
     */
    private ThreadedTreeNode preTemp;

    public void frontShow(){
        this.root.fontShow();
    }

    /**
     * 中序线索话二叉树
     */
    public void midThreadNodes(ThreadedTreeNode node) {
        // left
        if (node.leftNode != null) {
            midThreadNodes(node.getLeftNode());
        }
        // mid
        if (node.getLeftNode() == null) {
            // 当前节点的左节点为空，指向前驱节点
            node.leftType = 1;
            node.leftNode = this.preTemp;
        }
        if (this.preTemp != null && this.preTemp.rightNode == null) {
            // 前驱节点的有指针为空，指向当前节点
            this.preTemp.rightType = 1;
            this.preTemp.rightNode = node;
        }
        this.preTemp = node;
        // right
        if (node.rightNode != null) {
            midThreadNodes(node.rightNode);
        }
    }

    public void threadIterator(){
        ThreadedTreeNode node = root;
        while (node != null) {
            // 根据根节点找到左叶子节点
            while (node.leftType == 0) {
                node = node.leftNode;
            }
            System.out.println(node.getValue());
            // 中
            while (node.rightType == 1) {
                node = node.rightNode;
                System.out.println(node.getValue());
            }
            // 右
            node = node.rightNode;
        }
    }

}
