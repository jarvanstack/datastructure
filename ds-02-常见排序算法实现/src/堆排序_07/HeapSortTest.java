package 堆排序_07;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/22 9:12
 */
public class HeapSortTest {
    public static void main(String[] args) throws Exception {
        int[] ints = {5,1,9,3,7,4,8,6,2};
        int[] sort = new HeapSort().sort(ints);
        for (int i : sort) {
            System.out.print(i);
        }
    }
}
