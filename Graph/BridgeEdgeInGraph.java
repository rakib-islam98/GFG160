

/*
Prob.: Bridge edge in a graph
Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], 
where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

Note:
An edge is called a bridge if removing it increases the number of connected components of the graph.
if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.

Examples :

Input:
c = 1, d = 2
Output: true
Explanation: From the graph, we can clearly see that blocking the edge 1-2 will result in disconnection of the graph.
Hence, it is a Bridge.

Input:
c = 0, d = 2
Output: false
Explanation: Blocking the edge between nodes 0 and 2 won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge Edges in the graph are marked with a blue line in the above image.
*/


class Solution {
    public void dfs(List<Integer>[] adj,int c,boolean[] visited)
    {
        visited[c]=true;
        for(int neighbour:adj[c])
        {
            if(!visited[neighbour])
            {
                dfs(adj,neighbour,visited);
            }
        }
    }
    
    public List<Integer>[] constructadj(int V, int[][] edges, int c, int d)
    {
        List<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }
        
        for(int[] edge:edges)
        {
            int a=edge[0],b=edge[1];
            if((a==c && b==d) || (a==d && b==c))
                continue;
            adj[a].add(b);
            adj[b].add(a);
        }
        return adj;
    }
    
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        List<Integer>[] adj=constructadj(V,edges,c,d);
        boolean[] visited=new boolean[V];
        dfs(adj,c,visited);
        
        return !visited[d];
    }
}
