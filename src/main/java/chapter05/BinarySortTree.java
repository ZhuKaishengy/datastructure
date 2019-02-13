package chapter05;

import lombok.Data;

/**
 * 二叉排序树
 * 对于每一个非叶子节点，其左节点比当前节点小，其有节点比当前节点大
 * @author zhukaishengy
 */
@Data
public class BinarySortTree {

    Node root;

    /**
     * 向二叉排序树中添加一个节点
     * @param node
     */
    public void add(Node node){
        // 空树
       if (this.root == null) {
           this.root = node;
           return;
       }
       // 非空树
        this.root.add(node);
    }

    /**
     * 中序遍历，二叉排序树的中序遍历为从小到大的顺序
     */
    public void midShow(){
        this.root.midShow();
    }

    /**
     * 根据value 进行查找
      * @param value
     * @return
     */
    public Node find(int value){
       if (this.root == null) {
           return null;
       }
       return this.root.find(value);
    }

    /**
     * 记录父节点
     */
    private Node pre = null;

    /**
     * 删除叶子节点，将其父节点的对应指针删除
     * @param value
     */
    public void removeLeaf(int value){
        if (this.root == null) {
            return;
        }
        this.root.removeLeaf(value,pre,0);
        this.root.removeLeaf(value,pre,1);
    }

    /**
     * 删除 有一个子节点的节点：将其父节点的指针指向其single的子节点
     * @param value
     */
    public void removeSingleChildNode(int value){
        if (this.root == null) {
            return;
        }
        this.root.removeSingleChildNode(value,pre,0);
        this.root.removeSingleChildNode(value,pre,1);
    }

    /**
     * 删除有两个子节点的节点，找到这个节点，找到这个节点的所有右子节点中最小的，将找到的删除，将其值赋给当前节点
     * @param value
     */
    public void removeDoubleChildNode(int value){
        Node node = this.find(value);
        if (node.getLeft() != null && node.getRight() != null) {
            // 有双子节点
            Node target = this.getMinNode(node.getRight());
            // 删除target
            if (target.getRight() == null) {
                this.removeLeaf(target.getValue());
            } else {
                this.removeSingleChildNode(target.getValue());
            }
            // 将node、target 值对换
            node.setValue(target.getValue());
        }
    }

    /**
     * node 为根节点，获取最小的节点
     * @param node
     */
    private Node getMinNode(Node node) {
        Node minNode = node;
        while (minNode.getLeft() != null) {
            minNode = minNode.getLeft();
        }
        return minNode;
    }
}
