package chapter06;

import lombok.Data;

@Data
public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 当前树高度
     * @return
     */
    public int height(){
        int lHeight = 0;
        int rHeight = 0;
        if (this.left != null) {
            lHeight = this.left.height();
        }
        if (this.right != null) {
            rHeight = this.right.height();
        }
        return Math.max(lHeight, rHeight) + 1;
    }
    /**
     * 当前节点左指数高度
     * @param
     * @return
     */
    public int leftHeight(){
        if (this.left == null) {
            return 0;
        }
        return this.left.height();
    }

    /**
     * 当前节点右指数高度
     * @param
     * @return
     */
    public int rightHeight(){
        if (this.right == null) {
            return 0;
        }
        return this.right.height();
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
        // 校验是否是平衡二叉树
        if (this.leftHeight() - this.rightHeight() > 1) {
            if (this.left.rightHeight() > this.left.leftHeight()) {
                // 需要双旋转
                this.left.leftRotate();
            }
            // 右旋转
            this.rightRotate();
        }
        if (this.rightHeight() - this.leftHeight() > 1){
            if (this.right.leftHeight() > this.right.rightHeight()) {
                // 需要双旋转
                this.right.rightRotate();
            }
            // 左旋转
            this.leftRotate();
        }
    }

    /**
     * 左旋转
     *    2
     *   1 4
     *    3 5
     *       6
     */
    private void leftRotate() {
        // 创建一个节点和根节点value一样
        Node newNode = new Node(this.value);
        // 根节点的右节点为新节点的右节点
        newNode.left = this.left;
        // 根节点的左节点的右节点为新节点的左节点
        newNode.right = this.right.left;
        this.right.left = null;
        // 当前节点的右指针为新节点
        this.left = newNode;
        // 当前节点的值为左子树的值，左指针指向左子树的左子树
        this.value = this.right.value;
        this.right = this.right.right;
    }

    /**
     * 右旋转
     *      8
     *     6 9
     *    5 7
     *   4
     */
    private void rightRotate() {

        // 创建一个节点和根节点value一样
        Node newNode = new Node(this.value);
        // 根节点的右节点为新节点的右节点
        newNode.right = this.right;
        // 根节点的左节点的右节点为新节点的左节点
        newNode.left = this.left.right;
        this.left.right = null;
        // 当前节点的右指针为新节点
        this.right = newNode;
        // 当前节点的值为左子树的值，左指针指向左子树的左子树
        this.value = this.left.value;
        this.left = this.left.left;
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
