package chapter02;

import lombok.ToString;

/**
 * 线性结构：栈
 */
@ToString
public class MyStack {

    private int[] elementData = new int[0];

    public Boolean isEmpty(){
        return elementData.length == 0;
    }

    public void push(int ele){
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

    public int pop(){
        if (isEmpty()) {
          throw new RuntimeException("empty stack");
        }
        int[] elementsNew = new int[elementData.length -1];
        // copy previous
        System.arraycopy(elementData, 0, elementsNew, 0, elementsNew.length);
        // remove last element
        this.elementData = elementsNew;
        return elementData[elementData.length -1];
    }

    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return elementData[elementData.length -1];
    }
}
