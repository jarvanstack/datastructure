package 快速排序_06;

import java.util.Arrays;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/6 20:36
 */
public class QuickSortCopy {
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归快速排序.
     */
    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    /**
     * partition（划分） 排序核心。
     * 将比中值小的值放到中值的左边，并返回中值的下标。
     */
    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）,这里使用左边第一个为基准值可观看性更好。
        int pivot = left;
        //下标+ 1 什么鬼.
        int index = pivot + 1;
        //循环这个下标当他小于 right
        for (int i = index; i <= right; i++) {
            //小于pivot的放左边，自然右边就是大于的.
            if (arr[i] < arr[pivot]) {
                //交换index和i的值.
                swap(arr, i, index);
                //index 下标增加
                index++;
            }
        }
        //交换基准 pivot 和 index -1 是和么鬼.这里
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    /**
     * 交换值（简单地将2个下标的值进行交换）
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
