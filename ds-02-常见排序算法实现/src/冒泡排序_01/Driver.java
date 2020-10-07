package 冒泡排序_01;

import java.io.BufferedInputStream;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/4 16:13
 */
public class Driver {
    public static void main(String[] args) {
        int[] ints = {2,4,5,3};
        int[] ints1 = BubbleSort.bubbleSort(ints);
        for (int i : ints1) {
            System.out.println(i);
        }
    }
}
