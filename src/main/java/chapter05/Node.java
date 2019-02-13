package chapter05;

import lombok.Data;

@Data
public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        int val = node.getValue();
        if (val < this.value) {
            // left
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            // right
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void midShow() {

        // left
        if (this.left != null) {
            this.left.midShow();
        }
        // mid
        System.out.print(this.value + " ");
        // right
        if (this.right != null) {
            this.right.midShow();
        }
    }

    public Node find(int value) {

        if (value == this.value) {
            // find it
            return this;
        } else if (value < this.value) {
            // left
            if (this.left == null) {
                // not exist
                return null;
            }
            return this.left.find(value);
        } else {
            // right
            if (this.right == null) {
                // not exist
                return null;
            }
            return this.right.find(value);
        }
    }

    /**
     * 移除一个节点
     * @param value 节点的值
     * @param pre 当前节点的父节点
     * @param side 左0 右1
     */
    public void removeLeaf(int value, Node pre, int side) {
        if (value == this.value) {
            // find it
            if (isLeaf() && pre != null) {
                // 叶子节点
                if (side == 0) {
                    pre.left = null;
                    return;
                }
                if (side == 1) {
                    pre.right = null;
                }
            }
        }  else if (value < this.value) {
            // left
            if (this.left == null) {
                // not exist
                return ;
            }
            this.left.removeLeaf(value, this,0);
        } else {
            // right
            if (this.right == null) {
                // not exist
                return ;
            }
            this.right.removeLeaf(value, this, 1);
        }
    }
    public void removeSingleChildNode(int value, Node pre, int side) {

        if (value == this.value) {
            // find it
            if (hasOneChild() && pre != null) {
                // 叶子节点
                if (side == 0) {
                    pre.left = this.left == null ? this.right : this.left;
                    return;
                }
                if (side == 1) {
                    pre.right = this.left == null ? this.right : this.left;;
                }
            }
        }  else if (value < this.value) {
            // left
            if (this.left == null) {
                // not exist
                return ;
            }
            this.left.removeSingleChildNode(value, this,0);
        } else {
            // right
            if (this.right == null) {
                // not exist
                return ;
            }
            this.right.removeSingleChildNode(value, this, 1);
        }
    }
    /**
     * 判断一个节点是不是叶子节点
     * @return
     */
    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    /**
     * 判断一个节点只有一个子节点
     * @return
     */
    public boolean hasOneChild(){
        return this.left == null || this.right == null;
    }


}
