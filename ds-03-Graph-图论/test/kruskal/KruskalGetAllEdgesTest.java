package kruskal;

import java.util.List;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/12/16 18:06
 */
public class KruskalGetAllEdgesTest {
    /**
     * 测试获取所有的边
     */
    public static void main(String[] args) {
        List<Kruskal.Edge> allEdges = new Kruskal().getAllEdges();
        for (Kruskal.Edge edge : allEdges) {
            System.out.println(edge);
        }
    }
}
