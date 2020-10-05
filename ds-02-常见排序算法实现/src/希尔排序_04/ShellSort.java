package 希尔排序_04;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/10/4 20:42
 */
public class ShellSort {
    public static int[] shellSort(int[] sourceArray) {
        int length = sourceArray.length;
        //给increment 赋值一个合适的初始值.
        int increment = length;

        //分而治之
        do {
            //更新increment.
            increment = increment / 3 + 1;
            //第一层遍历 ++
            for (int i = increment; i < length; i++) {
                int temp = sourceArray[i];
                int j = i;
                while ( j-increment >=0 && temp < sourceArray[j-increment] ){
                    sourceArray[j] = sourceArray[j-increment];
                    j-=increment;
                }
                if (j!=i){
                    sourceArray[j] = temp;
                }
            }
        }while (increment > 1);
        return sourceArray;
    }
}
