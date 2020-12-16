import crossLinkedList.CrossLinkedListGraph;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/25 18:46
 */
public class CrossLinkedListTest {
    public static void main(String[] args) {
        CrossLinkedListGraph<String> graph = new CrossLinkedListGraph<>(4);
        graph.putVertex("A");
        graph.putVertex("B");
        graph.putVertex("C");
        graph.putVertex("D");

        graph.putEdge(0,1,4);
        graph.putEdge(0,2,3);
        graph.putEdge(2,3,5);
        graph.putEdge(2,0,5);
        graph.putEdge(3,0,6);
        graph.putEdge(3,1,6);
        graph.print();
        //获得一个点的fromEdge然后打印
        graph.printVertexFromEdge(0);

    }
}
