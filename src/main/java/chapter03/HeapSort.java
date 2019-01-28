package chapter03;

import java.util.Arrays;

/**
 * 堆排序
 * 大顶堆：每一个根节点比其子节点都大（用于升序排序）
 * 小顶堆：每一个根节点比其自节点都小（用于降序排序）
 * 将待排序数组排序成大顶堆，将根节点和最后一个叶子节点进行交换，并取出作为排好序数组的第一个元素，以此类推
 */
public class HeapSort {

    private void sort(int[] arr, int size) {

        // 开始位置为最后一个叶子节点的父节点，这个节点前面的节点都是非叶子节点
        int beginIndex = (size - 1) / 2;
        // 将arr 调整为大顶堆
        for (int i = beginIndex; i >= 0; i--) {
            maxHeap(arr, size, i);
        }
        // 交换
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        // recursive
        size --;
        if (size > 1) {
            sort(arr, size);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将一个数组转为大顶堆
     * @param arr   待排序数组
     * @param index 当前的非叶子节点索引
     */
    public void maxHeap(int[] arr, int size, int index){
        int leftNodeIndex = 2 * index + 1;
        int rightNodeIndex = 2 * index + 2;
        // 获取最大的index
        int maxIndex = index;
        if (leftNodeIndex < size && arr[leftNodeIndex] > arr[maxIndex]) {
            maxIndex = leftNodeIndex;
        }
        if (rightNodeIndex < size && arr[rightNodeIndex] > arr[maxIndex]) {
            maxIndex = rightNodeIndex;
        }
        // swap index
        if (maxIndex != index) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            maxHeap(arr, size, maxIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 8, 7, 0, 1, 10, 4, 2};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, arr.length);
    }
}
