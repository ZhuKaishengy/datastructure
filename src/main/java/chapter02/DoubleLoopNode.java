package chapter02;

/**
 * 双向循环链表
 */
public class DoubleLoopNode {

    private DoubleLoopNode pre = this;

    private DoubleLoopNode next = this;

    private int data;

    public DoubleLoopNode(int data) {
        this.data = data;
    }

    public DoubleLoopNode getPre(){
        return this.pre;
    }

    public DoubleLoopNode getNext(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }

    public void after(DoubleLoopNode node) {
        DoubleLoopNode nextNode = this.next;
        this.next = node;
        node.pre = this;
        node.next = nextNode;
        nextNode.pre = node;
    }
}
