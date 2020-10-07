package 归并排序_05;

import java.util.Arrays;

/**
 * This Merge Sort Algorithm will use a lot of  memory because the recursion【递归】
 *
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/6 9:11
 */
public class MergeSort {
    public static int[] mergeSort(int[] sourceArray){
        int length = sourceArray.length;
        //只有一个元素时候停止递归
        if (length <= 1){
            return sourceArray;
        }
        //因为失去精度，这样取出的中间值会让奇数的length，leftArray分得多一个的元素
        int middle = length - length/2;
        int[] leftArray = Arrays.copyOfRange(sourceArray,0,middle);
        int[] rightArray = Arrays.copyOfRange(sourceArray,middle,length);
        return merge(mergeSort(leftArray),mergeSort(rightArray));
    }
    private static int[] merge(int[] leftArray,int[] rightArray){
        int[] merge = new int[leftArray.length+rightArray.length];
        //开始组合并排序
        int indexOfMerge = 0;
        while (leftArray.length > 0 && rightArray.length > 0){
            if (leftArray[0] < rightArray[0]){
                merge[indexOfMerge++] = leftArray[0];
                leftArray = Arrays.copyOfRange(leftArray,1,leftArray.length);
            }else {
                merge[indexOfMerge++] = rightArray[0];
                rightArray = Arrays.copyOfRange(rightArray,1,rightArray.length);
            }
        }
        //排列剩下的左边的元素left
        while (leftArray.length > 0 ){
            merge[indexOfMerge++] = leftArray[0];
            leftArray = Arrays.copyOfRange(leftArray,1,leftArray.length);
        }
        //排列剩下的右边的元素.
        while (rightArray.length >0 ){
            merge [indexOfMerge ++] = rightArray[0];
            rightArray = Arrays.copyOfRange(rightArray,1,rightArray.length);
        }
        return merge;
    }
}
