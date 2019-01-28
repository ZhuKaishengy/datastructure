package chapter03;

import java.util.Arrays;

/**
 * 基数排序：适用于待排序数组位数不同的
 * 先按个位进行比较，结果放入事先准备好的 0～9 号桶（队列）中，全部遍历完，按0～9的顺序进行取出，之后按十位进行排序。。。
 * 按 个位、十位、百位。。。的顺序进行比较，次数取决于最大的数的位数
 *
 */
public class RadixSort {


    public void sort(int[] arr){
        // 获取比较的次数
        int maxValue = Integer.MIN_VALUE;
        for (int anArr : arr) {
            if (anArr > maxValue) {
                maxValue = anArr;
            }
        }
        int maxCount = String.valueOf(maxValue).length();
        // 初始化桶进行存储
        int[][] bucket = new int[10][arr.length];
        // 定义数组，用于存储桶中对应数组元素的个数
        int[] indexArr = new int[10];
        // 遍历
        for (int i = 0, n = 1; i < maxCount; i++, n *= 10) {

            // 将元素放入桶中
            for (int j = 0 ; j < arr.length; j++) {
                // 获取当前位上的数字
                int bitValue = arr[j] / n % 10;
                // 将元素存入桶中
                bucket[bitValue][indexArr[bitValue]] = arr[j];
                // 更新索引数组的值
                indexArr[bitValue] ++;
            }
            // 按桶号取出更新arr
            int index = 0;
            // 遍历索引下标
            for (int j = 0; j < indexArr.length; j++) {
                // 有值的桶
                for (int k = 0; k < indexArr[j]; k++) {
                    arr[index] = bucket[j][k];
                    index ++;
                }
            }
            // 初始化桶和索引
            bucket = new int[10][arr.length];
            indexArr = new int[10];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {15, 247, 1, 98, 271,5};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
    }
}
