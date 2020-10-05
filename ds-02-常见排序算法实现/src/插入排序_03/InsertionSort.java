package 插入排序_03;

import java.util.Arrays;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/4 19:15
 */
public class InsertionSort {
    public static int[] insertionSort(int[] sourceArray) {
        int length = sourceArray.length;
        //复制一份新的数组防止改变之前的数据，可选
        int[] copyArray = Arrays.copyOf(sourceArray, length);
        //第一个不用插入，我们从第二个开始
        for (int i = 1; i < length; i++) {
            int temp = copyArray[i];
            //temp小于前面的数字，前面的数字这个向后方移动一位，向temp方向.
            int j ;
            for ( j = i; j > 0 && temp < copyArray[j-1]; j--) {
                copyArray[j] = copyArray[j-1];
            }
            //temp插入
            copyArray[j] = temp;

        }
        return copyArray;
    }
}
