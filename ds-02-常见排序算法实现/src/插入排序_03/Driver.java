package 插入排序_03;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/4 19:29
 */
public class Driver {
    public static void main(String[] args) {
        int[] ints = {4,2,1,3};
        int[] ints1 = InsertionSort.insertionSort(ints);
        for (int i : ints1) {
            System.out.println(i);
        }
    }
}
