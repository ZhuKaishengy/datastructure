package chapter03;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 将两个排序好的数组合并成一个,递归的思想，拆分到两个数
     * @param arr 待排序数组
     * @param beginIndex 数组的起始位置
     * @param endIndex 数组的结束位置
     * @param splitIndex 数组的切割位置
     * @return
     */
    public void merge(int[] arr, int beginIndex, int endIndex ,int splitIndex) {

        int[] result = new int[endIndex - beginIndex + 1];
        int arr1Index = beginIndex;
        int arr2Index = splitIndex + 1;
        for (int i = 0; i < result.length; i++) {
            // 其中一个没有元素了
            if (arr1Index > splitIndex) {
                result[i] = arr[arr2Index];
                arr2Index ++;
                continue;
            }
            if (arr2Index > endIndex) {
                result[i] = arr[arr1Index];
                arr1Index ++;
                continue;
            }
            // common judge
            if (arr[arr1Index] < arr[arr2Index]) {
                result[i] = arr[arr1Index];
                arr1Index ++;
            } else {
                result[i] = arr[arr2Index];
                arr2Index ++;
            }
        }
        // 重新负值
        for (int i = 0; i < result.length; i++) {
            arr[beginIndex] = result[i];
            beginIndex ++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr, int begin, int end) {
        int middle = ( begin + end ) / 2;
        if (begin < end) {
            this.sort(arr, begin, middle);
            this.sort(arr, middle + 1, end);
            this.merge(arr, begin, end, middle);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 2};
//        int[] arr = {5, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr,0,arr.length -1);
    }

}
