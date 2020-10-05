package 希尔排序_04;

/**
 * int失去精度.
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/4 21:17
 */
public class Driver {
    public static void main(String[] args) {
        int [] ints = {1,3,4,2};
        int[] ints1 = ShellSort.shellSort(ints);
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }
    }
}
