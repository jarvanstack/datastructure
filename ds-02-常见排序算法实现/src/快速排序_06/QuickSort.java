package 快速排序_06;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/7 14:12
 */
public class QuickSort {
    /**
     * 调用递归快速排序
     */
    public int[] sort(int[] arrays) {
        return quickSort(arrays, 0, arrays.length - 1);
    }

    /**
     * 递归快速排序
     */
    private int[] quickSort(int[] array, int left, int right) {
        //如果数组的元素个数为1 完成退出递归.

        if (left < right) {
            //调用partition（）将小的值放到左边，并返回中间值的位置
            int middle = partition(array, left, right);
            //递归继续排序中值左边的数组和右边的数组，直到数组的元素个数为1
            quickSort(array, left, middle - 1);
            quickSort(array, middle + 1, right);
        }

        return array;
    }

    /**
     * partition 是划分的意思，这个方法是核心
     * 将比中值小的值移动到右边并返回移动后中值的下标
     */
    private int partition(int[] array, int left, int right) {
        //这里举例以最左边的值作为中值.
        int middle = left;
        //重点理解，【index】指针(下标)的作用，（实现值的交换）
        int index = middle + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[middle]) {
                //如果比中值小就交换.
                swap(array, index, i);
                index++;
            }
        }
        //将中值放置到数组的中间
        swap(array, middle, index - 1);
        return index - 1;
    }

    /**
     * 简单的交换2个下标的值.
     */
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
