package 冒泡排序_01;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/4 16:13
 */
public class BubbleSort {
    /**
     * Bubble sort
     *
     * @param arrays
     * @return
     */
    public static int[] bubbleSort(int[] arrays) {
        int length = arrays.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arrays[j + 1] < arrays[j]) {
                    //相邻位置交换值
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }

            }
        }
        return arrays;
    }
}
