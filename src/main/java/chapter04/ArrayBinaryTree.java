package chapter04;

/**
 * 顺序存储的二叉树，用于完全二叉树
 */
public class ArrayBinaryTree {

    /**
     * 简单起见，固定长度为6
     */
    private int[] elements;

    public void setElements(int[] elements) {
        this.elements = elements;
    }
    /**
     * 前序遍历
     */
    public void frontShow(int index){
        if (elements.length > 0) {
            // 中
            System.out.print(elements[index]);
            // 前
            if (2 * index + 1 < elements.length) {
                this.frontShow(2 * index + 1);
            }
            // 后
            if (2 * index + 2 < elements.length) {
                this.frontShow(2 * index + 2);
            }
        }
    }
}
