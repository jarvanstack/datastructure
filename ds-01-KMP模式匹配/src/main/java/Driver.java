/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/9/29 15:00
 */
public class Driver {
    public static void main(String[] args) {
        //测试暴力匹配
        KMPMatch hello_force_match = new KMPMatch("hello mach force match");
        int match = hello_force_match.KMPMatch("match");
        System.out.println(match);
    }
}
