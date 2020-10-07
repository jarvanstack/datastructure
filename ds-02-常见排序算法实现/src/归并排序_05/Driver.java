package 归并排序_05;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/6 12:36
 */
public class Driver {
    public static void main(String[] args) throws Exception {
        int[] ints = {5,1,9,3,7,4,8,6,2};
        int[] sort = MergeSort.mergeSort(ints);
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
