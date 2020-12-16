/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/20 9:38
 */
public class TableSizeForTest {
    public static void main(String[] args) {
        int n = 17;
        n |= n >>>1;
        n |= n >>>2;
        System.out.println(n);
//        测试3右移动2位结果
        System.out.println("测试3右移动2位结果");
        int n2 = 3;
        n2 |= n2 >>> 2;
        System.out.println("binary="+Integer.toBinaryString(n2));
        n2 |= n2 >>> 4;
        System.out.println("binary="+Integer.toBinaryString(n2));
    }
}
