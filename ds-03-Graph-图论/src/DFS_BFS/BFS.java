package DFS_BFS;

import java.util.Queue;

/**
 * Breadth First Search 广度最先搜索.
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/27 8:51
 */
public class BFS {
    //A, B, C,D, E, F
    static int[][] graph = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}};
    static int[] visited = new int[graph.length];//用来记录已经遍历过的元素


    //BFS(广度优先遍历)同样适用于有向图 A->C->D->B->E->F 即0->2->3->1->4->5
    public static void bfsTraversing(int[][] graph) {
        //初始化一个队列.
        int[] queue=new int[graph.length];
        //cnt means???
        int cnt=1;
        //将A作为起始顶点加入队列
        queue[0]=0;
        visited[0]=1;
        System.out.println(0);
        //如果小于cnt ？？？？
        //遍历队列里的东西？？？
        for (int i=0;i<cnt;++i){
            for (int j=0;j< queue.length;++j){
                //cnt 队列长度？？？
                //
                if (queue[i]!=j&&graph[queue[i]][j]==1&& visited[j]==0){
                    visited[queue[i]]=1;
                    queue[cnt++]=j;
                    System.out.println(j);
                }
            }
        }
    }
    public static void bfs2(int[][] graph){
    }

    public static void main(String[] args) {
        bfsTraversing(graph);
    }
}
