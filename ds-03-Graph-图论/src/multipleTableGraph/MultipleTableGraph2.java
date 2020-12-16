package multipleTableGraph;

import adjcencyLinkedList.AdjacencyTableGraph;

import java.util.ArrayList;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/26 13:07
 */
public class MultipleTableGraph2<E> {
    private class Vertex{
        private E elementVertex;
        private Edge firstEdge;

        public Vertex(E elementVertex, Edge firstEdge) {
            this.elementVertex = elementVertex;
            this.firstEdge = firstEdge;
        }
    }
    private class Edge{
        private int iVertex;
        private int jVertex;
        /** ILink的jVertex 必须等于 this.iVertex */
        private Edge iLink;
        private Edge jLink;
    }
    private int numOfVertices;
    private int maxOfVertices;
    private ArrayList<Vertex> vertices;
    public MultipleTableGraph2(int maxOfVertices)  {
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

}
