package chapter03;

import java.util.Arrays;

/**
 * 冒泡排序
 * 外层循环一次，冒出一个最大值
 * 内层循环一次，两两比较，进行交换
 * 时间复杂度：O(n^2)
 */
public class BubbleSort {

    /**
     * 5 2 9 1
     * 2 5 1 9
     * 2 1 5 9
     * 1 2 5 9
     * @param arr
     */
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
    }
}
