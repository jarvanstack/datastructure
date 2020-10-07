package 快速排序_06;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/7 11:59
 */
public class CopyTest {
    public static void main(String[] args) throws Exception {
        QuickSortCopy quickSortCopy = new QuickSortCopy();
        QuickSort quickSort = new QuickSort();
        int[] ints = {5,1,9,3,7,4,8,6,2};
        int[] sort = quickSort.sort(ints);
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
