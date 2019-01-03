package chapter02;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * 单链表：链式存储结构
 */
@Data
@Accessors(chain = true)
@ToString
public class Node {

    private int data;

    private Node next;

    public Node(int data){
        this.data = data;
    }

    /**
     * 向链表中追加元素
     * @param node
     * @return
     */
    public Node append(Node node){
        Node currentNode = this;
        while (true) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                currentNode.next = node;
                break;
            }
            currentNode = nextNode;
        }
        return this;
    }

    /**
     * 从链表中删除某个节点数据
     * @param nodeData
     * @return
     */
    public Node remove(int nodeData){
        Node currentNode = this;
        Node previousNode = null;
        while (true) {
            Node nextNode = currentNode.next;

            if (Objects.equals(currentNode.data, nodeData)) {
                // delete currentNode
                if (previousNode == null) {
                    return null;
                }
                if (nextNode == null) {
                    previousNode.next = null;
                    return this;
                }
                previousNode.next = nextNode;
                return this;
            }

            if (nextNode == null) {
                // 到达链尾，循环终止
                break;
            }

            previousNode = currentNode;
            currentNode = nextNode;
        }
        throw new RuntimeException("节点不存在");

    }

    /**
     * 在当前节点后面插入一个节点
     * @param node
     * @return
     */
    public Node insert(Node node){
        Node nextNode = this.next;
        if (nextNode == null) {
            this.next = node;
            node.next = null;
        } else {
            this.next = node;
            node.next = nextNode;
        }
        return this;
    }

    /**
     * 是否是最后一个节点
     * @return
     */
    public boolean isLast(){
       return this.next == null;
    }

    /**
     * 链表中是否包含某个节点数据
     * @param nodeData
     * @return
     */
    public boolean contains(int nodeData){
        Node currentNode = this;
        while (true) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                // 到达链尾，循环终止
                break;
            }
            if (Objects.equals(currentNode.data, nodeData)) {
                return true;
            }
            currentNode = nextNode;
        }
        return false;

    }
}
