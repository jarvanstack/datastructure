package unionFind;

/**
 * 并查集
 * @author Jarvan
 * @version 1.0
 * @create 2020/12/15 17:10
 */
public class UnionFind {
    char[] items = {'A','B','C','D','E'};
    int [] parents = {0,0,0,3,3};
    public int find(int itemIndex){
        //求出父节点的 index下标
        int parentIndex = parents[itemIndex];
        //如果父节点的下标等于本身，那么这个节点就是根节点
        if (itemIndex == parentIndex){
            return itemIndex;
        }
        //不是根节点，以父节点为基础，递归找到根节点
        return find(parentIndex);
    }

    /**
     * 路径压缩
     */
    public int find3(int itemIndex){
        //求出父节点的 index下标
        int parentIndex = parents[itemIndex];
        //如果父节点的下标等于本身，那么这个节点就是根节点
        if (itemIndex == parentIndex){
            return itemIndex;
        }
        //父节点设置为根节点
        parents[itemIndex] = find(parents[itemIndex]);
        return parents[itemIndex];
    }

    public int find2(int itemIndex){
        return itemIndex == parents[itemIndex]? itemIndex : find(parents[itemIndex]);
    }
    public void union(int masterTree,int slaveTree){
        //找到主树的根节点
        int masterTreeRoot = find(masterTree);
        //找到从树的根节点
        int slaveTreeRoot = find(slaveTree);
        //将从树的根节点的父节点设置为主树的根节点
        parents[slaveTree] = masterTree;
    }
    /**
     * 初始化所有的层级为1
     */
    private int[] rank = {1,1,1,1};
    public void union2(int tree1,int tree2){
        //找到根节点
        int tree1Root = parents[tree1];
        int tree2Root = parents[tree2];
        //如果树 1 的层级更高，让树 2 的根节点的父节点的值为树 1 的根节点
        if (rank[tree1Root] > rank[tree2Root]){
            parents[tree2Root] = tree1Root;
        }
        //反之
        else if (rank[tree1Root] < rank[tree2Root]){
            parents[tree1Root] = tree2Root;
        }
        //如果相等的层级，那么谁当「主树」都一样，需要将树的层级增加一层。
        else {
            parents[tree2Root] = tree1Root;
            rank[tree1Root] ++;
        }
    }
}
