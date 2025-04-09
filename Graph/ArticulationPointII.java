
/*
Prob.: Articulation Point - II
You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], 
where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.

Examples :

Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]
Output: [1, 4]
Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
Input: V = 4, edges[][] = [[0, 1], [0, 2]]
Output: [0]
Explanation: Removing the vertex 0 will increase the number of disconnected components to 3. 
*/


class Solution {
    static ArrayList<ArrayList<Integer>> constructadj(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
    
    static void findPoints(ArrayList<ArrayList<Integer>> adj,int u,int[] visited,int[] disc,
    int[] low,int[] time,int parent,int[] isAP)
    {
        visited[u]=1;
        disc[u]=low[u]=++time[0];
        int children=0;
        
        for(int v:adj.get(u))
        {
            if(visited[v]==0)
            {
                children++;
                findPoints(adj,v,visited,disc,low,time,u,isAP);
                low[u]=Math.min(low[u],low[v]);
                if(parent!=-1 && low[v]>=disc[u])
                {
                    isAP[u]=1;
                }
            }
            else if(v!=parent)
            {
                low[u]=Math.min(low[u],disc[v]);
            }
        }
        if(parent==-1 && children>1)
        {
            isAP[u]=1;
        }
    }
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=constructadj(V,edges);
        int[] disc=new int[V],low=new int[V],visited=new int[V],isAP=new int[V];
        int[] time={0};
        
        for(int u=0;u<V;u++)
        {
            if(visited[u]==0)
            {
                findPoints(adj,u,visited,disc,low,time,-1,isAP);
            }
        }
        
        ArrayList<Integer> result=new ArrayList<>();
        for(int u=0;u<V;u++)
        {
            if(isAP[u]==1)
                result.add(u);
        }
        
        if(result.isEmpty()) result.add(-1);
        return result;
    }
}
