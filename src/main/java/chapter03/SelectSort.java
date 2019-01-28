package chapter03;

import java.util.Arrays;

/**
 * 选择排序：一次循环找到最小的元素
 */
public class SelectSort {

    public void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex == i) {
                continue;
            }
            // swap index i and minIndex
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 2, 7, 9, 4, 6};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(arr);
    }
}
