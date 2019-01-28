package chapter03;

import java.util.Arrays;

/**
 * 快速排序
 * 指针的思想，开始位置，结束位置，base元素
 * 1、从结束位置开始，比base小，end指针向元素复制到start位置，比base大，指针前移
 * 2、从开始位置开始，比base大，start指针向元素复制到end位置，比base小，指针后移
 * 3、排序完成一遍将base元素复制到重合的指针位置
 */
public class QuickSort {

    /**
     * get middle element
     * @param arr
     * @param begin
     * @param end
     */
    public int getMiddle(int[] arr, int begin, int end){
        // 获取初始指针位置
        int beginPointer = begin;
        int endPointer = end;
        int baseEle = arr[beginPointer];
        while (beginPointer < endPointer) {

            // 获取需要排序的begin和end指针
            while (arr[endPointer] > baseEle && endPointer > beginPointer) {
                endPointer --;
            }
            // 把小值赋给begin指针，指针后移
            arr[beginPointer] = arr[endPointer];

            while (arr[beginPointer] < baseEle && endPointer > beginPointer) {
                beginPointer ++;
            }
            // 把大值赋给end指针，指针迁移
            arr[endPointer] = arr[beginPointer];
        }
        // begin、end 指针重合，将baseEle值赋给重合指针
        arr[beginPointer] = baseEle;
        System.out.println("一次循环：" + Arrays.toString(arr));
        return beginPointer;
    }

    public void sort(int[] arr, int begin, int end) {
        // recursive condition
        if (begin < end) {
            int middlePointer = this.getMiddle(arr, begin, end);
            // recursive before middle
            this.sort(arr, begin, middlePointer - 1);
            // recursive after middle
            this.sort(arr, middlePointer + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 2, 7, 9, 4, 6};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
    }
}
