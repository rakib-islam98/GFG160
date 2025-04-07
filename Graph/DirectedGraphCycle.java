
/*
Prob.: Directed Graph Cycle
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3], [3, 3]]
Output: true
Explanation: 3 -> 3 is a cycle

Input: V = 3, edges[][] = [[0, 1], [1, 2]]
Output: false
Explanation: no cycle in the graph
*/



class Solution {
    public List<Integer>[] constructadj(int V,int[][] edges)
    {
        List<Integer>[] adj=new ArrayList[V];
        
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }
        
        for(int[] edge:edges)
        {
            adj[edge[0]].add(edge[1]);
        }
        
        return adj;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<Integer>[] adj=constructadj(V,edges);
        
        int[] inDegree=new int[V];
        
        Queue<Integer> q=new LinkedList<>();
        int visited=0;
        
        for(int u=0;u<V;u++)
        {
            for(int v:adj[u])
            {
                inDegree[v]++;
            }
        }
        
        for(int u=0;u<V;u++)
        {
            if(inDegree[u]==0)
            {
                q.offer(u);
            }
        }
        
        while(!q.isEmpty())
        {
            int u=q.poll();
            visited++;
            
            for(int v:adj[u])
            {
                inDegree[v]--;
                if(inDegree[v]==0)
                {
                    q.offer(v);
                }
            }
        }
        
        return visited!=V;
    }
}
