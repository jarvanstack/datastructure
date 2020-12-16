package 堆排序_07;

import java.util.Arrays;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/7 18:54
 */
public class HeapSort {
    /**
     * 排序
     */
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    /**
     * 创建一个heap.
     */
    private void buildMaxHeap(int[] arr, int len) {
        for (int i = len/2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**m
     * Heapify 堆化.
     */
    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    /**
     * swap 简单的交换数据。
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
