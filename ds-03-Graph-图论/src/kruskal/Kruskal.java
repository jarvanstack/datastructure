package kruskal;

import com.sun.javafx.geom.Edge;
import com.sun.xml.internal.bind.v2.util.EditDistance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

/**
 * Kruskal 算法实现找到最小生成树
 *
 * @author Jarvan
 * @version 1.0
 * @create 2020/12/16 17:15
 */
public class Kruskal {
    /** 顶点 */
    private static Character[] vertices;
    /** Graph 邻接矩阵 */
    private static int[][] graph;
    /** 定义最大值 */
    private static final int   MAX = Integer.MAX_VALUE;
    public static int[] parents;
    //初始化数据
    static{
        vertices = new Character[]{'A', 'B', 'C', 'D'};
        graph = new int[][]{
                 {0,3,3,7}
                ,{3,0,2,4}
                ,{3,2,0,6}
                ,{7,4,6,0}};
        //初始化parent为他们自己
        parents = new int[]{0,1,2,3};
    };
    /** 定义边 Edge */
    class Edge  implements Comparator<Edge> {
        int from;
        int to;
        int weight;

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compare(Edge edge1, Edge edge2) {
            if (edge1.weight > edge2.weight){
                return 1;
            }
            else if ( edge1.weight < edge2.weight){
                return -1;
            }
            return 0;
        }
    }
    /** 取出所有的边封装为集合 */
    public  List<Edge> getAllEdges(){
        ArrayList<Edge> edges = new ArrayList<>();
        int length = graph.length;
        //遍历每点
        for (int i = 0; i < length; i++) {
            //遍历每个点的边
            for (int j = 0; j < length; j++) {
                boolean isContain = false;
                //如果没有重复的边就添加集合中
                for (Edge edge : edges) {
                    //weight 相等
                    if (edge.weight == graph[i][j]){
                        //判断
                        if ((i == edge.from && j == edge.to)||(j == edge.from && i == edge.to)){
                            isContain = true;
                        }
                    }

                }
                //如果没有包含就添加到 edges 里面
                //并且权重不能为 0
                if (isContain == false && graph[i][j] != 0){
                    edges.add(new Edge(i,j,graph[i][j]));
                }
            }
        }
        return edges;
    }
    /** 排序边 (这里使用快速排序QuickSort)  */
    public void sortEdges(List<Edge> edges){
        quickSort(edges,0,edges.size()-1);
    }
    private void quickSort(List<Edge> edges,int left ,int right){
        //如果可以元素大于 1 就可以排序
        if (left < right){
            //分割 将小的值放大左边返回中间值的位置
            int middle = partition(edges, left, right);
            quickSort(edges,left,middle-1);
            quickSort(edges,middle+1,right);
        }
    }
    private int partition(List<Edge> edges,int left ,int right){
        //中值先不动
        int middleWeight = edges.get(left).weight;
        //中值最后因该在的位置
        int middleLocation  = left + 1;
        //将小的值放到左边 |middle|...小的值...|...大的值...|
        for (int i = left+1;i <= right;i++){
            //如果出现比中值 小 的值
            if (middleWeight >= edges.get(i).weight){
                //交换到middleLocation的位置
                Edge tempEdge = edges.get(i);
                edges.set(i,edges.get(middleLocation));
                edges.set(middleLocation,tempEdge);
                middleLocation ++;
            }

        }
        //将 middleWeight 中值放到 这个位置 |...小的值...|中值|...大的值...|
        Edge tempEdge = edges.get(middleLocation-1);
        edges.set(middleLocation-1,edges.get(left));
        edges.set(left,tempEdge);
        //返回最后中值所在的位置
        return middleLocation-1;
    }

    public ArrayList<Integer> kruskal(){
        //已经连接的点
        ArrayList<Integer> connectedVertices = new ArrayList<>();
        //获取图中的所有的边
        List<Edge> edges = getAllEdges();
        //将所有的边进行排序
        sortEdges(edges);
        //这里使用并查集寻找出最小生成树
        for (int i = 0; i < edges.size(); i++) {
            int fromVertexIndex = edges.get(i).from;
            int toVertexIndex = edges.get(i).to;
            boolean sameTree = find(fromVertexIndex) == find(toVertexIndex);
            //如果不是同一个树
            if (sameTree == false){
                System.out.println(vertices[fromVertexIndex] + " --> " + vertices[toVertexIndex] + " weight:" +graph[fromVertexIndex][toVertexIndex]);
                //合并为同一个树
                union(find(fromVertexIndex),find(toVertexIndex));
                //包含 to 点就添加 from 点
                if (connectedVertices.contains(toVertexIndex)) {
                    connectedVertices.add(fromVertexIndex);
                }
                //包含 from 点 就添加 to 点
                else if (connectedVertices.contains(fromVertexIndex)){
                    connectedVertices.add(toVertexIndex);
                }
                // 2 个都不包含就都添加
                else {
                    connectedVertices.add(fromVertexIndex);
                    connectedVertices.add(toVertexIndex);
                }
            }
            //如果全部点都已经连接就退出循环
            if (connectedVertices.size() == vertices.length){
                break;
            }
        }
        return connectedVertices;
    }
    /** 查 */
    private int find(int vertexIndex){
        return parents[vertexIndex] == vertexIndex ? vertexIndex : find(parents[vertexIndex]);
    }
    /** 并 */
    private void union(int mainTree, int slaveTree){
        int mainTreeRoot = find(mainTree);
        int slaveTreeRoot = find(slaveTree);
        parents[slaveTree] = mainTreeRoot;
    }



    public static void main(String[] args) {
        //测试QuickSort
        Kruskal kruskal = new Kruskal();
//        List<Edge> edges = kruskal.getAllEdges();
//        kruskal.sortEdges(edges);
        kruskal.kruskal();
    }


}
