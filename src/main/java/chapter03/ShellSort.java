package chapter03;

import java.util.Arrays;

/**
 * 希尔排序：
 * 设定步长，初始步长为length/2，之后 / 2
 *
 */
public class ShellSort {

    public void sort(int[] arr) {
        // iterator step
        for (int d = arr.length / 2; d > 0; d /= 2) {
            // 遍历所有元素
            for (int i = d; i < arr.length; i++) {
                // 遍历本组中的元素
                for (int j = i - d ; j >= 0; j -= d) {
                    if (arr[j] > arr[j + d]) {
                        // swap
                        int tmp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = tmp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 2};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr);
    }
}
