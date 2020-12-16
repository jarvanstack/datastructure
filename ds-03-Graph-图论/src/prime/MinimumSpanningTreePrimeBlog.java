package prime;

import java.util.ArrayList;

/**
 * 最小生成树Prime「普利姆」算法
 * @author Jarvan
 * @version 1.0
 * @create 2020/12/13 20:59
 */
public class MinimumSpanningTreePrimeBlog {
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
     * 1.将起始点（A）添加到已经连接的点  `connectedVertices`
     * 2.遍历 `connectedVertices` 每一个顶点的每一条边（这个边能指向 `connectedVertices` 中的值），找到**最小的边**，添加到 `connectedVertices` 中
     * 3.循环步骤2，直到 `connetedVertices` 中包含所有的顶点。
     *
     * @param startIndex 开始顶点的index
     * @return 返回最小生成树的权重和
     */
    public static ArrayList<Integer> prime(int startIndex){
        //已经连接的点
        ArrayList<Integer> connectedVertices = new ArrayList<>();
        //1.将开始顶点放入连接的顶点中
        connectedVertices.add(startIndex);
        //循环步骤2，连接所有顶点后才结束
        while (connectedVertices.size() < graph.length){
            //最小权重
            int minWeight = Integer.MAX_VALUE;
            //最小权重的 from 起始节点 （用于打印输出）
            int minWeightFrom = -1;
            //最小权重的 to 指向节点 （用于打印输出）
            int minWeightTo = -1;

            //遍历已连接顶点
            for (int i = 0; i < connectedVertices.size(); i++) {
                //遍历已连接顶点的每一条边
                for (int j = 0; j < graph[connectedVertices.get(i)].length; j++) {
                    int tempWeight = graph[connectedVertices.get(i)][j];
                    //不能指向已经连接的顶点
                    if (!connectedVertices.contains(j)){
                        //出现更小的值符合条件就将重新赋值最小值
                        if (tempWeight < MAX && tempWeight > 0 && tempWeight < minWeight){
                            minWeight = tempWeight;
                            minWeightFrom = connectedVertices.get(i);
                            minWeightTo = j;
                        }
                    }
                }
            }
            //最后将最小的值加入到连接节点中，循环步骤 2
            System.out.println(vertices[minWeightFrom]+" --> " + vertices[minWeightTo] + " weight = " +minWeight);
            connectedVertices.add(minWeightTo);
        }
        return connectedVertices;
    }

    public static void main(String[] args) {
        prime(0);
    }

}
