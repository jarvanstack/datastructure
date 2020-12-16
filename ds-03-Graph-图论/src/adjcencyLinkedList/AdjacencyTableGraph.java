package adjcencyLinkedList;


import java.util.ArrayList;

/**
 * 邻接表graph实现.
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/21 16:22
 */
public class AdjacencyTableGraph <E>{
    private class Vertex{
        private E elementVertex;
        private Edge next;

        public Vertex(E elementVertex, Edge next) {
            this.elementVertex = elementVertex;
            this.next = next;
        }
    }
    private class Edge{
        private int toVertex;
        private int weight;
        private Edge nextEdge;

        public Edge(int toVertex, int weight, Edge nextEdge) {
            this.toVertex = toVertex;
            this.weight = weight;
            this.nextEdge = nextEdge;
        }
    }
    private int numOfVertices;
    private int maxOfVertices;
    private ArrayList<Vertex> vertices;

    public AdjacencyTableGraph(int maxOfVertices)  {
        this.maxOfVertices = maxOfVertices;
        this.vertices = new ArrayList<>(maxOfVertices);
        numOfVertices = 0;
    }
    public boolean putVertex(E vertex){
        if (numOfVertices < maxOfVertices){
            vertices.add(new Vertex(vertex,null));
            numOfVertices ++;
            return true;
        }
        return false;
    }
    public E getVertex(int vertexIndex){
        if (vertexIndex<maxOfVertices){
            return vertices.get(vertexIndex).elementVertex;
        }
        return null;
    }
    public boolean putEdge(int fromVertex,int toVertex,int weight){
        if (fromVertex < maxOfVertices && toVertex < maxOfVertices) {
            Vertex from = vertices.get(fromVertex);
            Edge edge = new Edge(toVertex,weight, null);
            if (from.next == null) {
                from.next = edge;
                return true;
            }
            //遍历链表将新的元素放到链表尾部
            Edge node = from.next;
            while (node.nextEdge != null){
                node = node.nextEdge;
            }
            node.nextEdge = edge;
            return true;
        }
        return false;
    }
    public int getWeight(int fromVertex, int toVertex){
        if (fromVertex < maxOfVertices && toVertex < maxOfVertices) {
            Vertex fromV = vertices.get(fromVertex);
            Edge node = fromV.next;
            while (node != null){
                if (node.toVertex == toVertex){
                    return node.weight;
                }
                node = node.nextEdge;
            }
        }
        return -1;
    }
    public void print(){
        for (Vertex vertex : vertices) {
            Edge node = vertex.next;
            while (node != null){
                System.out.println("节点"+vertex.elementVertex+" to 节点 "+vertices.get(node.toVertex).elementVertex +" weight " +node.weight);
                node = node.nextEdge;
            }
        }
    }
}
