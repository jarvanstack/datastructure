package multipleTableGraph;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/26 12:14
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/12/9.
 * 无向图的邻接多重表的实现
 * 优点： 使用邻接表在对边进行操作时(如删除),需要两次操作，因为一条边在两个链表里面存储，
 * 而邻接多重表的优点就在于对边操作时只需要一次操作，这就意味着边只存储一次
 */
public class MultipleTableGraph {
    /**
     * vName-->顶点名称
     * firstEdge-->顶点边链表的头结点
     */
    private static class Vertex {
        private String vName;
        private Edge firstEdge;
        public Vertex(String name) {
            this.vName = name;
        }
    }

    /**
     * iVex-->边的其中一个顶点A
     * iLink-->边中顶点A的边链表的指针
     * jVex-->边的另一个顶点B
     * jLink-->边中顶点B的边链表的指针
     */
    private static class Edge {
        private int iVex;
        private Edge iLink;
        private int jVex;
        private Edge jLink;

        public Edge() {}
        public Edge(int iVex,int jVex) {
            this.iVex = iVex;
            this.jVex = jVex;
        }
    }

    private static class GraphEdge {
        private String vex;
        private String otherVex;

        public GraphEdge(String vexName,String otherVexName) {
            this.vex = vexName;
            //
            this.otherVex = otherVexName;
        }
    }

    private List<Vertex> vertexArr;

    public void init(String[] vexArr,List<GraphEdge> edgeList) {
        initVexArr(vexArr);
        initEdge(edgeList);
    }

    private void initVexArr(String[] vexArr) {
        vertexArr = new ArrayList<Vertex>(vexArr.length);
        for(int i = 0;i < vexArr.length;i++) {
            Vertex vertex = new Vertex(vexArr[i]);
            vertexArr.add(vertex);
        }
    }

    private void initEdge(List<GraphEdge> edgeList) {
        for(int i = 0;i < edgeList.size();i++) {
            GraphEdge graphEdge = edgeList.get(i);
            if(contains(graphEdge.vex) && contains(graphEdge.otherVex)) {
                //获取顶点的下标
                int vIndex = getVexIndex(graphEdge.vex);
                int oIndex = getVexIndex(graphEdge.otherVex);
                //获取顶点
                Vertex vertex = vertexArr.get(vIndex);
                Vertex oVertex = vertexArr.get(oIndex);
                //构造两个顶点的边
                Edge edge = new Edge(vIndex,oIndex);
                //头插法插入vertex的边
                if(vertex.firstEdge == null) {
                    vertex.firstEdge = edge;
                } else {
                    Edge vexNextEdge = vertex.firstEdge;
                    edge.iLink = vexNextEdge;
                    vertex.firstEdge = edge;
                }
                //头插法插入oVertex的边
                if(oVertex.firstEdge == null) {
                    oVertex.firstEdge = edge;
                } else {
                    Edge oVexNextEdge = oVertex.firstEdge;
                    edge.jLink = oVexNextEdge;
                    oVertex.firstEdge = edge;
                }


            }

        }
    }

    private boolean contains(String vName) {
        for(Vertex vertex : vertexArr) {
            if(vertex.vName.equals(vName))
                return true;
        }
        return false;
    }

    private int getVexIndex(String vName) {
        for(int i = 0;i < vertexArr.size();i++) {
            if(vertexArr.get(i).vName.equals(vName))
                return i;
        }
        return -1;
    }

    public void print() {
        for(Vertex vertex : vertexArr) {
            System.out.println("顶点 " + vertex.vName + " 的所有边: ");
            int vIndex = getVexIndex(vertex.vName);
            Edge cursor = vertex.firstEdge;
            while (cursor != null) {
                System.out.print(cursor.iVex + "---" + cursor.jVex + " ||");
                if(cursor.iVex == vIndex) {
                    cursor = cursor.iLink;
                } else {
                    cursor = cursor.jLink;
                }
            }

            System.out.println();
        }
    }

    //删除边
    /**
     * 删除边的整体思路
     * 1.找到边上的两个顶点A和B
     * 2.分别遍历AB的边链表，直到找到要删除的边S
     * 3.分别将边S及边S的前驱边PS的数据存储起来,这里A的要删除的边为cursor，前驱边为preCursor,B的要删除的边为oCursor,前驱边为oPreCursor
     * 4.调整链表结构
     * @param graphEdge
     */
    public void remove(GraphEdge graphEdge) {
        String vName = graphEdge.vex;
        String oName = graphEdge.otherVex;
        int vIndex = getVexIndex(vName);
        int oIndex = getVexIndex(oName);
        //处理边的第一个顶点A
        Vertex vertex = vertexArr.get(vIndex);
        Edge cursor = vertex.firstEdge;
        //指针的前驱
        Edge preCursor = null;

        while (cursor != null) {
            if(cursor.iVex == oIndex || cursor.jVex == oIndex) {
                //通过遍历顶点A的所有边，找到边的前驱指针
                break;
            }
            preCursor = cursor;
            if(cursor.iVex == vIndex) {
                cursor = cursor.iLink;
            } else {
                cursor = cursor.jLink;
            }
        }

        //处理边的第二个顶点B
        Vertex oVertex = vertexArr.get(oIndex);
        Edge oCursor = oVertex.firstEdge;
        //指针的前驱
        Edge oPreCursor = null;

        while (oCursor != null) {
            if(oCursor.iVex == vIndex || oCursor.jVex == vIndex) {
                //通过遍历顶点B的所有边，找到边的前驱指针
                break;
            }
            oPreCursor = oCursor;
            if(oCursor.iVex == oIndex) {
                oCursor = oCursor.iLink;
            } else {
                oCursor = oCursor.jLink;
            }
        }

        if(preCursor != null) {
            if(preCursor.iVex == vIndex && cursor.iVex == vIndex) {
                preCursor.iLink = cursor.iLink;
            } else if(preCursor.iVex == vIndex && cursor.jVex == vIndex) {
                preCursor.iLink = cursor.jLink;
            } else if(preCursor.jVex == oIndex && cursor.iVex == vIndex) {
                preCursor.jLink = cursor.iLink;
            } else {
                preCursor.jLink = cursor.jLink;
            }
        } else {
            if(cursor.iVex == vIndex) {
                vertex.firstEdge = cursor.iLink;
            } else {
                vertex.firstEdge = cursor.jLink;
            }
        }

        if(oPreCursor != null) {
            if(oPreCursor.iVex == oIndex && oCursor.iVex == oIndex) {
                oPreCursor.iLink = oCursor.iLink;
            } else if(oPreCursor.iVex == oIndex && oCursor.jVex == oIndex) {
                oPreCursor.iLink = oCursor.jLink;
            } else if(oPreCursor.jVex == oIndex && oCursor.iVex == oIndex) {
                oPreCursor.jLink = oCursor.iLink;
            } else {
                oPreCursor.jLink = oCursor.jLink;
            }
        } else {
            if(oCursor.iVex == oIndex) {
                oVertex.firstEdge = oCursor.iLink;
            } else {
                oVertex.firstEdge = oCursor.jLink;
            }
        }


    }

    public static void main(String[] args) {
        MultipleTableGraph graph = new MultipleTableGraph();
        String[] vexArr = {"V0","V1","V2","V3"};
        GraphEdge edge = new GraphEdge("V0","V1");
        GraphEdge edge1 = new GraphEdge("V0","V2");
        GraphEdge edge2 = new GraphEdge("V0","V3");
        GraphEdge edge3 = new GraphEdge("V1","V2");
        GraphEdge edge4 = new GraphEdge("V2","V3");

        List<GraphEdge> edgeList = new ArrayList<GraphEdge>();
        edgeList.add(edge);
        edgeList.add(edge1);
        edgeList.add(edge2);
        edgeList.add(edge3);
        edgeList.add(edge4);

        graph.init(vexArr,edgeList);
        graph.remove(edge3);
        graph.print();
    }




}
