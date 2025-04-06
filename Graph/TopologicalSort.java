
/*
Prob.: Topological sort
Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], 
where each entry edges[i] = [u, v] denotes an directed edge u -> v. Return topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
*/



class Solution {
    public static void topoSortUtil(int v,List<Integer>[] adj,boolean[] visited,Stack<Integer> stack)
    {
        visited[v]=true;
        
        for(int i:adj[v])
        {
            if(!visited[i])
            {
                topoSortUtil(i,adj,visited,stack);
            }
        }
        stack.push(v);
    }
    public static List<Integer>[] constructadj(int V,int[][] edges)
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
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[V];
        
        List<Integer>[] adj=constructadj(V,edges);
        
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                topoSortUtil(i,adj,visited,stack);
            }
        }
        
        ArrayList<Integer> result=new ArrayList<>();
        while(!stack.isEmpty())
        {
            result.add(stack.pop());
        }
        
        return result;
    }
}
