package chapter01;


import java.util.Arrays;
import java.util.Objects;

/**
 * 线性结构：数组
 * 自己实现arrayList
 */
public class MyArrayList<E> {

    private Object[] elementData;

    private int initialSize = 10;

    public MyArrayList(int initialSize) {
        if (initialSize >= 0) {
            this.initialSize = initialSize;
            elementData = new Object[initialSize];
        } else {
            throw new RuntimeException("initial size must bigger then zero !!!");
        }
    }
    public MyArrayList() {
        elementData = new Object[]{};
    }

    public int size(){
        return elementData.length;
    }

    public E get(int index){
        checkBound(index);
        return (E)elementData[index];
    }
    public void set(int index, E data) {
        checkBound(index);
        this.elementData[index] = data;
    }

    /**
     * 线性查找
     * @param data
     * @return
     */
    public int indexOf(E data){
        for (int i = 0; i < this.size(); i++) {
            if (Objects.equals(data, elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法查找，排序之后的数据
     * @param data
     * @return
     */
    public int binaryIndexOf(int data, Sort sort){
       int begin = 0;
       int end = this.size() -1 ;
       while (true) {
           int middle = (begin + end) / 2;

           if (Objects.equals(sort, Sort.Increase)) {
               if ((int)elementData[middle] == data) {
                   return middle;
               }
               if ((int)elementData[middle] > data) {
                   end = middle -1;
               }
               if ((int)elementData[middle] < data) {
                   begin = middle + 1;
               }
               if (begin == end) {
                   return -1;
               }
           } else {
               if ((int)elementData[middle] == data) {
                   return middle;
               }
               if ((int)elementData[middle] > data) {
                   begin = middle + 1;
               }
               if ((int)elementData[middle] < data) {
                   end = middle -1;
               }
               if (begin == end) {
                   return -1;
               }
           }
       }

    }

    private void checkBound(int index){
        if (index > this.size()) {
            throw new RuntimeException("outoff bound!!!");
        }
    }

    public MyArrayList<E> add(E ele){
        Object[] arrNew = new Object[elementData.length + 1];
        System.arraycopy(elementData, 0, arrNew, 0, elementData.length);
        arrNew[arrNew.length -1] = ele;
        this.elementData = (E[]) arrNew;
        return this;
    }

    public MyArrayList<E> remove(int index) {
        checkBound(index);
        Object[] arrNew = new Object[this.size() - 1];
        for (int i = 0; i < arrNew.length; i++) {
            if (i < index) {
                arrNew[i] = elementData[i];
            } else {
                arrNew[i] = elementData[i + 1];
            }
        }
        elementData = (E[])arrNew;
        return this;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }

    public enum Sort {
        Increase, Decrease;
    }
}
