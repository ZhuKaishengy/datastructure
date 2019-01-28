package chapter04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 链式存储结构中的二叉树的任何一个节点
 * @author zhukaishengy
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TreeNode {

    private int val;
    private TreeNode lNode;
    private TreeNode rNode;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 遍历的前中后针对当前节点（root）
     * 前序遍历
     */
    public void fontShow() {
        // 中
        System.out.print(this.getVal() + " ");
        // 左
        if (this.getLNode() != null ){
            this.getLNode().fontShow();
        }
        // 右
        if (this.getRNode() != null) {
            this.getRNode().fontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        // 左
        if (this.getLNode() != null ){
            this.getLNode().midShow();
        }
        // 中
        System.out.print(this.getVal() + " ");
        // 右
        if (this.getRNode() != null) {
            this.getRNode().midShow();
        }
    }

    /**
     * 后序遍历
     */
    public void forwardShow() {
        // 左
        if (this.getLNode() != null ){
            this.getLNode().forwardShow();
        }
        // 右
        if (this.getRNode() != null) {
            this.getRNode().forwardShow();
        }
        // 中
        System.out.print(this.getVal() + " ");
    }

    /**
     * 前序查找
     */
    public TreeNode fontSearch(int ele) {

        // 用来保存美轮查询的结果，通过 result != null 判断没找到
        TreeNode result = null;
        // 中
        if (this.getVal() == ele) {
            return this;
        }
        // 左
        if (this.getLNode() != null ) {
            result = this.getLNode().fontSearch(ele);
        }
        if (result != null) {
            return result;
        }
        // 右
        if (this.getRNode() != null) {
            result = this.getRNode().fontSearch(ele);
        }
        return result;
    }
    /**
     * 中序查找
     */
    public TreeNode midSearch(int ele) {

        // 用来保存美轮查询的结果，通过 result != null 判断没找到
        TreeNode result = null;

        // 左
        if (this.getLNode() != null ) {
            result = this.getLNode().midSearch(ele);
        }
        if (result != null) {
            return result;
        }
        // 中
        if (this.getVal() == ele) {
            return this;
        }
        // 右
        if (this.getRNode() != null) {
            result = this.getRNode().midSearch(ele);
        }
        return result;
    }
    /**
     * 后序查找
     */
    public TreeNode forwardSearch(int ele) {

        // 用来保存美轮查询的结果，通过 result != null 判断没找到
        TreeNode result = null;

        // 左
        if (this.getLNode() != null ) {
            result = this.getLNode().forwardSearch(ele);
        }
        if (result != null) {
            return result;
        }
        // 右
        if (this.getRNode() != null) {
            result = this.getRNode().forwardSearch(ele);
        }
        // 中
        if (this.getVal() == ele) {
            return this;
        }
        return result;
    }

    /**
     * 删除子树
     * @param ele
     */
    public void delSubTree(int ele) {
        // find ele 's parents node
        TreeNode parent = this;
        if (parent.getLNode() != null && parent.getLNode().getVal() == ele) {
            parent.setLNode(null);
            return;
        }
        if (parent.getRNode() != null && parent.getRNode().getVal() == ele) {
            parent.setRNode(null);
            return;
        }
        if (parent.getLNode() != null) {
            parent = parent.getLNode();
            parent.delSubTree(ele);
        }
        if (parent.getRNode() != null) {
            parent = parent.getRNode();
            parent.delSubTree(ele);
        }

    }
}
