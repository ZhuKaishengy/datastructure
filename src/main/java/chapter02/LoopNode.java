package chapter02;

/**
 * 循环链表
 */
public class LoopNode {

    private int data;

    private LoopNode next;

    public LoopNode (int data){
        this.data = data;
        this.next = this;
    }

    public int getData() {
        return data;
    }

    public LoopNode getNext() {
        return next;
    }

    public void after(LoopNode node) {
        LoopNode nextNode = this.next;
        this.next = node;
        node.next = nextNode;
    }

    @Override
    public String toString() {
        return "LoopNode{" +
                "data=" + data +
                '}';
    }
}
