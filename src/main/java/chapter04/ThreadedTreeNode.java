package chapter04;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 线索二叉树节点
 */
@Data
@Accessors(chain = true)
@ToString
public class ThreadedTreeNode {

    private int value;

    public ThreadedTreeNode leftNode;

    public ThreadedTreeNode rightNode;

    /**
     * 左指针和右指针类型
     * 0：指数
     * 1：线索
     */
    public int leftType;
    public int rightType;

    public ThreadedTreeNode(int value) {
        this.value = value;
    }

    /**
     * 前序遍历
     */
    public void fontShow(){

        System.out.print(value + " ");

        if (this.leftNode != null) {
            this.leftNode.fontShow();
        }

        if (this.rightNode != null) {
            this.rightNode.fontShow();
        }
    }

}
