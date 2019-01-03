package chapter02;

import lombok.ToString;

/**
 * 线性结构：队列
 */
@ToString
public class MyQueue {

    private int[] elementData = new int[0];

    public Boolean isEmpty(){
        return elementData.length == 0;
    }

    public void add(int ele){
        int[] elememtsNew = new int[elementData.length + 1];
        if (isEmpty()) {
            elememtsNew[0] = ele;
        } else {
            // copy previous
            System.arraycopy(elementData, 0, elememtsNew, 0, elementData.length);
            // set last element
            elememtsNew[elememtsNew.length -1] = ele;
        }
        this.elementData = elememtsNew;
    }

    public int poll(){
        if (isEmpty()) {
          throw new RuntimeException("empty stack");
        }
        int[] elementsNew = new int[elementData.length -1];
        // copy previous
        System.arraycopy(elementData, 1, elementsNew, 0, elementsNew.length);
        // remove last element
        int removeEle = this.elementData[0];
        this.elementData = elementsNew;
        return removeEle;
    }

    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return elementData[0];
    }
}
