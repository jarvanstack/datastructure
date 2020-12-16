package DFS_BFS;

/**
 * Deep First Search
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/27 8:37
 */
public class DFS {
    //A, B, C,D, E, F
    static int[][] graph = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}};
    static int[] visited = new int[graph.length];//用来记录已经遍历过的元素
    //DFS(深度优先遍历)同样适用于有向图 A->C->B->D->E->F 即 0->2->1->3->4->5
    public static void  dfsTraversing(int node, int[][] graph) {
        //遍历输出
        visited[node]=1;
        System.out.println(node);
        //循环一个长度
        for (int i = 0; i < graph[node].length; ++i) {
            //visited = 0；就是这个节点没有visited
            //i != node 就是传入的visited节点不是node，我们需要以node节点的下一个节点为基础，DFS
            //graph[node][i] == 1 保证这个node节点的下一个节点是可以通行的
            if (visited[i]==0&&i != node&&graph[node][i]==1) {
                dfsTraversing(i, graph);
            }
        }
    }

    public static void main(String[] args) {
        dfsTraversing(0,graph);
    }


}
