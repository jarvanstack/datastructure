package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/27 10:29
 */
public class BFS2 {
    //A, B, C,D, E, F
    static int[][] graph = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}};
    static boolean[] visited = new boolean[graph.length];//用来记录已经遍历过的元素

    public static void bfs(int[][] graph,int firstNode){
        LinkedList<Integer> queue = new LinkedList<>();
        int length = graph.length;
        System.out.println(firstNode);
        visited[firstNode] = true;
        queue.offer(firstNode);
        while (queue.size() > 0){
            //poll出一个值
            int node = queue.poll();
            //遍历这个行
            for (int i = 0; i < length; i++) {
                //如果行中有可以通行的点i
                //并且这个通行的点i没visited
                if (graph[node][i] != 0 && visited[i] == false) {
                    System.out.println(i);
                    //标记visited
                    visited[i] = true;
                    //就将这个点i入队列
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        bfs(graph,0);
    }
}
