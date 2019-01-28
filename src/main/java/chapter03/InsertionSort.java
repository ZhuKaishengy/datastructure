package chapter03;

import java.util.Arrays;

/**
 * 插入排序：从第二个元素开始，默认前面的都有顺序
 * 从后向前遍历，后面元素后移
 */
public class InsertionSort {

    public void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    // 交换
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            // 获取待比较元素
            int tmp = arr[i];
            int j;
            // 从后向前遍历其前面的元素
            for (j = i - 1; j >= 0 && tmp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 2, 7, 9, 4, 6};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort2(arr);
    }
}
