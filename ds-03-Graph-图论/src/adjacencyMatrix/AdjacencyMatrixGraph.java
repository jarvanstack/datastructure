package adjacencyMatrix;

import java.util.ArrayList;

/**
 * Adjacent Matrix 邻接矩阵的实现类
 * https://segmentfault.com/a/1190000002685782
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/20 16:50
 */
public class AdjacencyMatrixGraph<E> {
    /** 顶点 */
    private ArrayList<E> vertices;
    /** 边 */
    private int[][] edges;
    private int numOfVertices;
    private int numOfEdges;
    private int maxNum;

    public AdjacencyMatrixGraph(int maxOfVertices) {
        maxNum = maxOfVertices;
        vertices = new ArrayList<>();
        edges = new int[maxOfVertices][maxOfVertices];
        //init valuation for edges.
        for (int i = 0; i < maxOfVertices; i++) {
            for (int j = 0; j < maxOfVertices; j++) {
                edges[i][j] = -1;
            }
        }
        numOfEdges = 0;
        numOfEdges = 0;
    }



    /**
     * 增 顶点
     * @param vertex
     * @return
     */
    public boolean putVertex(E vertex){
        if (numOfVertices < maxNum){
            vertices.add(numOfVertices,vertex);
            numOfVertices ++;
            return true;
        }
        return false;
    }

    /**
     * 查 顶点
     * @param indexOfVertex
     * @return
     */
   public E getVertex(int indexOfVertex){
        return vertices.get(indexOfVertex);
    }

    /**
     * 删 顶点
     * @param indexOfVertex
     * @return
     */
   public boolean removeVertex(int indexOfVertex){
        vertices.set(indexOfVertex,null);
        return true;
    }
    /**
     * 增 边
     * @param indexOfVertex1
     * @param indexOfVertex2
     * @param weight
     * @return
     */
    public boolean putEdge(int indexOfVertex1, int indexOfVertex2, int weight){
        if (indexOfVertex1 < maxNum && indexOfVertex2 < maxNum){
            edges[indexOfVertex1][indexOfVertex2] = weight;
            return true;
        }
        return false;
    }

    /**
     * 查 边
     * @param indexOfVertex1
     * @param indexOfVertex2
     * @return
     */
    public int getWeight(int indexOfVertex1,int indexOfVertex2 ){
        if (indexOfVertex1 < maxNum && indexOfVertex2 < maxNum){
            return edges[indexOfVertex1][indexOfVertex2];
        }
        return -1;
    }

    /**
     * 删边 (权重)
     * @param indexOfVertex1
     * @param indexOfVertex2
     * @return
     */
    public boolean removeEdge(int indexOfVertex1,int indexOfVertex2){
        if (indexOfVertex1 < maxNum && indexOfVertex2 < maxNum){
            edges[indexOfVertex1][indexOfVertex2] = -1;
            return true;
        }
        return false;
    }
    /**
     * 【重要】路径算法dijkstra 最短路径
     */
    public int dijkstra(int fromVertex,int toVertex){

        return -1;
    }

    /**
     * 打印Graph
     */
    public void print(){
        int length = this.edges.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (this.edges[i][j] != -1){
                    //存在权值
                    E fromVertex = getVertex(i);
                    E toVertex = getVertex(j);
                    System.out.println("节点："+fromVertex+" to 节点"+toVertex+" , 权重"+this.edges[i][j]);
                }
            }
        }
    }


}
