
/*
Prob.: Undirected Graph Cycle
Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], 
where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

Examples:

Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation: 
 
1 -> 2 -> 0 -> 1 is a cycle.
Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation: 
 
No cycle in the graph.
*/


class Solution {
    boolean isCycleUtil(int v,List<Integer>[] adj,boolean[] visited,int parent)
    {
        visited[v]=true;
        for(int i:adj[v])
        {
            if(!visited[i])
            {
                if(isCycleUtil(i,adj,visited,v))
                    return true;
            }
            else if(i!=parent)
            {
                return true;
            }
        }
        return false;
    }
    List<Integer>[] constructadj(int V,int[][] edges)
    {
        List<Integer>[] adj=new ArrayList[V];
        
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }
        return adj;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<Integer>[] adj=constructadj(V,edges);
        
        for(int[] edge:edges)
        {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        boolean[] visited=new boolean[V];
        
        for(int u=0;u<V;u++)
        {
            if(!visited[u])
            {
                if(isCycleUtil(u,adj,visited,-1))
                    return true;
            }
        }
        return false;
    }
}
