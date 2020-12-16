package prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 最小生成树Prime「普利姆」算法
 * @author Jarvan
 * @version 1.0
 * @create 2020/12/13 20:59
 */
public class MinimumSpanningTreePrime {
    /**
     * 顶点
     */
    private static Character[] vertices;
    /**
     * Graph 邻接矩阵
     */
    private static int[][] graph;
    private static final int   MAX = Integer.MAX_VALUE;
    /**
     * 初始化数据
     */
    static{
        vertices = new Character[]{'A', 'B', 'C', 'D'};
        graph = new int[][]{   {0,3,MAX,7}
                                ,{3,0,2,4}
                                ,{MAX,2,0,6}
                                ,{7,4,6,0}};
        };

    /**
     * prime算法
     * 1. A、（index为0） 入 connectedVertices，while（连接的点个数小于4）
     * 2. 遍历每个connectedVertices的「出度 横向」，找出值最小且没有连接到遍历过的顶点的顶点
     * 3. 将这个最小出度的顶点放入 connectedVertices 里面，输出连接的边「例如，A -> B weight」，继续while
     * @param startIndex 开始顶点的index
     * @return 返回最小生成树的权重和
     */
    public static ArrayList<Integer> prime(int startIndex){
        //已经连接的点
        ArrayList<Integer> connectedVertices = new ArrayList<>();
        //临时储存一个点「出度」
        int[] outDegree = graph[startIndex];
        //将开始顶点放入连接的顶点中
        connectedVertices.add(startIndex);
        //直到连接到所有顶点
        while (connectedVertices.size() < graph.length){
            //最小权重
            int minWeight = Integer.MAX_VALUE;
            //最小权重的from节点
            int minWeightFrom = -1;
            //最小权重的 to 节点
            int minWeightTo = -1;
            //遍历已连接顶点
            for (int i = 0; i < connectedVertices.size(); i++) {
                //遍历已连接顶点的出度
                for (int j = 0; j < graph[connectedVertices.get(i)].length; j++) {
                    int tempWeight = graph[connectedVertices.get(i)][j];
                    //不能包含已经访问过的点
                    if (!connectedVertices.contains(j)){
                        //出现更小的值符合条件就替换
                        if (tempWeight < MAX && tempWeight > 0 && tempWeight < minWeight){
                            minWeight = tempWeight;
                            minWeightFrom = connectedVertices.get(i);
                            minWeightTo = j;
                        }
                    }
                }
            }
            //最后将最小的值加入到连接节点中
            System.out.println(vertices[minWeightFrom]+" --> " + vertices[minWeightTo] + " weight = " +minWeight);
            connectedVertices.add(minWeightTo);
        }
        return connectedVertices;
    }

    public static void main(String[] args) {
        prime(0);
    }

}
