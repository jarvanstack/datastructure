package 归并排序_05;

import java.util.Arrays;

/**
 * This Merge Sort Algorithm will use a lot of  memory because the recursion【递归】
 *
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/6 9:11
 */
public class MergeSort复制 {

    /**
     * 1.分而治之
     */
    public static int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        //只有一个元素 就不用继续拆分了。
        if (arr.length < 2) {
            return arr;
        }
        //失去精度，左边的可能要大.
        int middle = arr.length - arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        //递归拆分直到只有一个元素，就开始真正的排序计算.
        return merge(sort(left), sort(right));
    }

    /**
     * 2.再合并，归并
     */
    protected static int[] merge(int[] left, int[] right) {
        //创建一个可以容纳左右数组的新数组.
        int[] result = new int[left.length + right.length];
        int i = 0;
        //依次排序左边右边数组的元素.【每次只排序一个元素保证排序的正确性】
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        //剩下的左边left的元素排序【right 数组使用完了，但是left还剩下的元素】
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        //剩下的右边的right的元素的排序【left数组排序完成后，但是right还剩下的元素】
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

}
