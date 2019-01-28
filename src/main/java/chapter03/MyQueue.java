package chapter03;

/**
 * 队列实现
 */
public class MyQueue {

    private int[] elements = new int[0];

    /**
     * 向队列中添加一个元素
     */
    public void add(int ele){
        int[] tmpArr = new int[elements.length + 1];
        System.arraycopy(elements,0, tmpArr, 0, elements.length);
        tmpArr[tmpArr.length - 1] = ele;
        elements = tmpArr;
    }

    /**
     * 从队列中取出一个元素
     * @return
     */
    public int poll(){
        this.checkEmpty();
        int[] tempArr = new int[elements.length - 1];
        System.arraycopy(elements, 1, tempArr, 0, tempArr.length);
        int ele = elements[0];
        this.elements = tempArr;
        return ele;
    }

    public boolean isEmpty(){
        return elements.length == 0;
    }

    private void checkEmpty(){
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        int poll1 = myQueue.poll();
        int poll2 =myQueue.poll();
        int poll3 =myQueue.poll();
        int poll4 =myQueue.poll();
        System.out.println(poll1);
        System.out.println(poll2);
        System.out.println(poll3);
        System.out.println(poll4);
        myQueue.poll();
    }
}
