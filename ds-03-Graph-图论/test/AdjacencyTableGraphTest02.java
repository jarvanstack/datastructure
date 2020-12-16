import adjcencyLinkedList.AdjacencyTableGraph;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/21 18:54
 */
public class AdjacencyTableGraphTest02 {
    public static void main(String[] args) {
        //顶点集合
        String[] vertices = {"A","B","C","D"};
        //创建一个顶点个数为4 的Graph
        AdjacencyTableGraph<String> graph = new AdjacencyTableGraph<>(vertices.length);
        //设置节点
        for (String vertex : vertices) {
            graph.putVertex(vertex);
        }
        //设置边
        graph.putEdge(0,1,4);
        graph.putEdge(0,2,3);
        graph.putEdge(0,3,7);
        graph.putEdge(1,2,5);
        graph.putEdge(3,2,6);
        //打印图
        graph.print();
        //获得顶点
        System.out.println(graph.getVertex(1));
        //删除节点
        //获得边
        System.out.println(graph.getWeight(0, 2));
//        删除边
        System.out.println(graph.getWeight(0, 2));
    }
}
