package crossLinkedList;




import java.util.ArrayList;

/**
 * 十字链表
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/25 16:43
 */
public class CrossLinkedListGraph<E> {


    class Vertex{
        E data;
        Edge firstIn;
        Edge firstOut;

        public Vertex(E data, Edge firstIn, Edge firstOut) {
            this.data = data;
            this.firstIn = firstIn;
            this.firstOut = firstOut;
        }
    }
    class Edge{
        int fromVertex;
        int toVertex;
        Edge fromEdge;
        Edge toEdge;
        int weight;

        public Edge(int fromVertex, int toVertex, Edge fromEdge, Edge toEdge, int weight) {
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
            this.fromEdge = fromEdge;
            this.toEdge = toEdge;
            this.weight = weight;
        }
    }
    private int numOfVertices;
    private int maxOfVertices;
    private ArrayList<Vertex> vertices;

    public CrossLinkedListGraph(int maxOfVertices) {
        this.maxOfVertices = maxOfVertices;
        this.vertices = new ArrayList<>(maxOfVertices);
        numOfVertices = 0;
    }


    public boolean putVertex(E data){
        if (numOfVertices < maxOfVertices){
            vertices.add(new Vertex(data,null,null));
            numOfVertices ++;
            return true;
        }
         return false;
    }
    public E getVertexData(int vertexIndex){
        if (vertexIndex<maxOfVertices){
            return vertices.get(vertexIndex).data;
        }
        return null;
    }
    /**
     * 插入边，横纵列表都要插入
     */
    public boolean putEdge(int fromVertexIndex,int toVertexIndex,int weight){
        if (fromVertexIndex < maxOfVertices && toVertexIndex < maxOfVertices){
            Vertex fromVertex = vertices.get(fromVertexIndex);
            Edge newEdge = new Edge(fromVertexIndex,toVertexIndex,null,null,weight);
            //插入横向链表
            if (fromVertex.firstOut == null) {
                fromVertex.firstOut = newEdge;
                //插入竖向链表
                return insertFromEdgeLinkedList(fromVertex.firstOut);
            }
            //遍历元素然后将元素放到尾部
            Edge edge = fromVertex.firstOut;
            while (edge.toEdge != null) {
                edge = edge.toEdge;
            }
            edge.toEdge = newEdge;
            //插入竖向链表
            return insertFromEdgeLinkedList(edge.toEdge);
        }
        return false;
    }

    /**
     * 将插入竖向链表提升为一个方法
     */
    private boolean insertFromEdgeLinkedList(Edge edge){
        if ( edge!=null){
            //获得新增加的指向的顶点
            Vertex toVertex = vertices.get(edge.toVertex);
            if (toVertex.firstIn==null){
                //如果指向的顶点没有竖向链表就直接将第一个边赋值给竖向链表
                toVertex.firstIn = edge;
                return true;
            }
            Edge fromEdge = toVertex.firstIn;
            while (fromEdge.fromEdge!=null){
                fromEdge = fromEdge.fromEdge;
            }
            fromEdge.fromEdge = edge;
            return true;
        }
        return  false;
    }

    public void print(){
        for (Vertex vertex : vertices) {
            Edge edge = vertex.firstOut;
            System.out.print(vertex.data+": ");
            while (edge!=null){
                System.out.print(vertices.get(edge.fromVertex).data
                        + " --> "
                        +vertices.get(edge.toVertex).data
                        +" weight="+edge.weight +"; ");
                edge = edge.toEdge ;
            }
            System.out.println();
        }
    }
    public void printVertexFromEdge(int fromVertex){
        System.out.println("====print vertex from edges====");
        Vertex vertex = vertices.get(fromVertex);
        Edge firstIn = vertex.firstIn;
        if (vertex.firstIn!=null){
            Edge fromEdge = vertex.firstIn;
             while (fromEdge!=null){//这里debug的时候录为null
                 System.out.println(vertices.get(fromEdge.fromVertex).data
                         +" --> "+
                         vertices.get(fromEdge.toVertex).data);
                 fromEdge = fromEdge.fromEdge;
             }
        }else {
            System.out.println("null of firstIn");
        }
    }


}
