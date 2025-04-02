
/*
Prob.: BFS of graph
Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], 
where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, 
visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps: 
Visit 0 → Output: 0 
Visit 2 (first neighbor of 0) → Output: 0, 2 
Visit 3 (next neighbor of 0) → Output: 0, 2, 3 
Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
*/


class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
        int s=0;
        
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        
        boolean[] visited=new boolean[V];
        
        visited[s]=true;
        q.add(s);
        
        while(!q.isEmpty())
        {
            int curr=q.poll();
            res.add(curr);
            
            for(int x:adj.get(curr))
            {
                if(!visited[x])
                {
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
        return res;
    }
}
