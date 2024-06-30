package learning.daliy;

/**
 * 0630. remove max number of edges to keep graph fully traversable
 *
 * Alice and Bob have an undirected graph of n nodes and three types of edges:
 * Type 1: Can be traversed by Alice only.
 * Type 2: Can be traversed by Bob only.
 * Type 3: Can be traversed by both Alice and Bob.
 * Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob.
 * The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
 *
 * Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.
 */
public class MaxNumEdgesToRemove_1579_0630 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Union uf1 = new Union(n+1);
        Union uf2 = new Union(n+1);
        int res = 0;
        for(int edge[]:edges){
            if(edge[0]==3){
                if(uf1.connected(edge[1],edge[2])&&uf2.connected(edge[1],edge[2])){
                    res++;
                    continue;
                }
                uf1.union(edge[1],edge[2]);
                uf2.union(edge[1],edge[2]);
            }
        }
        for(int edge[]:edges){
            if(edge[0]==1){
                if(uf1.connected(edge[1],edge[2])){
                    res++;
                    continue;
                }
                uf1.union(edge[1],edge[2]);
            } else if(edge[0]==2) {
                if(uf2.connected(edge[1],edge[2])){
                    res++;
                    continue;
                }
                uf2.union(edge[1],edge[2]);
            }
        }
        if(uf1.count()==1&&uf2.count()==1){
            return res;
        }
        return -1;
    }

class Union {
    int parent[];
    int size[];
    int count;
    public Union (int n){
        parent = new int[n];
        size = new int[n];
        count = n-1;
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public void union(int index1,int index2){
        int root1 = find(index1);
        int root2 = find(index2);
        if(root1==root2){return;}
        if(size[root1]>size[root2]){
            parent[root2] = root1;
            size[root1] += size[root2];
        } else {
            parent[root1] = root2;
            size[root2] += size[root1];
        }
        count--;
    }
    public int find(int index){
        while(index!=parent[index]){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    public boolean connected(int index1,int index2){
        return find(index1)==find(index2);
    }
    public int count(){
        return count;
    }
}

    public static void main(String[] args) {
        System.out.println("test");
    }

}
