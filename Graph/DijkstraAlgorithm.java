
/*
Prob.: Dijkstra Algorithm
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], 
where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, 
and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

Note: The Graph is connected and doesn't contain any negative weight edge.

Examples:

Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
Output: [4, 3, 0]
Explanation:
Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2

Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
Output: [0, 4, 8, 10, 10]
Explanation: 
Shortest Paths: 
For 0 to 1 minimum distance will be 4. By following path 0 -> 1
For 0 to 2 minimum distance will be 8. By following path 0 -> 2
For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
*/



class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        //Create adjacency list
        List<List<int[]>> adj=new ArrayList<>();
        //Create V vertices ArrayList
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        //For each vertex add all{neighbour,distance} as ArrayList
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            int cost=edge[2];
            //As it's undirected
            adj.get(u).add(new int[]{v,cost});
            adj.get(v).add(new int[]{u,cost});
        }
        
        //Priority queue to select minimum cost node each time, {dist,ind}
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,src});
        
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int u=curr[1];
            int cost=curr[0];
            
            if(cost<dist[u]) continue;
            
            for(int[] neighbour:adj.get(u))
            {
                int v=neighbour[0];
                int d=neighbour[1];
                
                if(dist[v]>cost+d)
                {
                    dist[v]=cost+d;
                    pq.add(new int[]{dist[v],v});
                }
            }
        }
        
        return dist;
    }
}
