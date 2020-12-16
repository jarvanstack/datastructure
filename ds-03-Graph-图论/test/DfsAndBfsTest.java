import DFS_BFS.DfsAndBfs;

import java.util.Date;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/11/27 13:07
 */
public class DfsAndBfsTest {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0}};


        //0 2 1 3 4 5
        new DfsAndBfs(graph).dfs(0);
        System.out.println("==========");
        //因为遍历会改变visited的值，所以需要重新构造对象
        //0 2 3 1 4 5
        new DfsAndBfs(graph).bfs(0);
    }
}
