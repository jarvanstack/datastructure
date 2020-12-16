import java.util.LinkedList;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/27 10:59
 */
public class QueueTest {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        //return first element and remove it.
        System.out.println(queue.poll());
        //return first element do not remove it.
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}
