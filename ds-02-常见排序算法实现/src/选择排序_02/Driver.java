package 选择排序_02;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/4 16:43
 */
public class Driver {
    public static void main(String[] args) {
        int[] ints = {4,3,1,2,0};
        int[] newInts = ChooseSort.chooseSort(ints);
        for (int newInt : newInts) {
            System.out.println(newInt);
        }
    }
}
