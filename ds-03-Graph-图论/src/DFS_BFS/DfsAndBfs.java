package DFS_BFS;


import java.util.LinkedList;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/27 13:00
 */
public class DfsAndBfs {
    /**
     * A,B,C,D,E,F
     * 0,1,2,3,4,5
     */
    private int[][] graph;
    /**
     * visited用来记录已经遍历过的元素
     */
    private boolean[] visited;

    public DfsAndBfs(int[][] graph) {
        this.graph = graph;
        visited = new boolean[graph.length];
    }
    /**
     * BFS(广度优先遍历) 基于队列实现
     */
    public  void bfs( int firstNode) {
        LinkedList<Integer> queue = new LinkedList<>();
        int length = graph.length;
        System.out.println(firstNode);
        visited[firstNode] = true;
        queue.offer(firstNode);
        while (queue.size() > 0) {
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

    /**
     * DFS 深度优先遍历 递归实现
     * （也可通过栈实现，因为递归的本质就是压栈）
     */
    public  void dfs(int node) {
        //遍历输出
        visited[node] = true;
        System.out.println(node);
        //循环一个长度
        for (int i = 0; i < graph[node].length; ++i) {
            //visited = false；就是这个节点没有visited
            //i != node 就是传入的visited节点不是node，我们需要以node节点的下一个节点为基础，DFS
            //graph[node][i] == 1 保证这个node节点的下一个节点是可以通行的
            if (visited[i] == false && i != node && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }

}
