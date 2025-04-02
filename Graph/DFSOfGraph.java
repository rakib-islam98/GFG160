
/*
Prob.: DFS of Graph
Given a connected undirected graph represented by a 2-d adjacency list adj[][], 
where each adj[i] represents the list of vertices connected to vertex i. 
Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list, 
and return a list containing the DFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 4, 3, 1]
Explanation: Starting from 0, the DFS traversal proceeds as follows:
Visit 0 → Output: 0 
Visit 2 (the first neighbor of 0) → Output: 0, 2 
Visit 4 (the first neighbor of 2) → Output: 0, 2, 4 
Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3 
Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1
*/


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[adj.size()];
        ArrayList<Integer> res=new ArrayList<>();
        dfsRec(adj,visited,0,res);
        return res;
    }
    public void dfsRec(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int s,ArrayList<Integer> res)
    {
        visited[s]=true;
        res.add(s);
        
        for(int i:adj.get(s))
        {
            if(!visited[i])
            {
                dfsRec(adj,visited,i,res);
            }
        }
    }
}
