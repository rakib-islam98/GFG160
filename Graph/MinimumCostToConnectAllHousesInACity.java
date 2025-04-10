
/*
Prob.: Minimum cost to connect all houses in a city
Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, 
the task is to find the minimum cost to connect all the houses of the city.

The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) 
and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.

Examples :

Input: n = 5 houses[][] = [[0, 7], [0, 9], [20, 7], [30, 7], [40, 70]]
Output: 105
Explanation:
Connect house 1 (0, 7) and house 2 (0, 9) with cost = 2
Connect house 1 (0, 7) and house 3 (20, 7) with cost = 20
Connect house 3 (20, 7) with house 4 (30, 7) with cost = 10 
At last, connect house 4 (30, 7) with house 5 (40, 70) with cost 73.
All the houses are connected now.
The overall minimum cost is 2 + 10 + 20 + 73 = 105.

Input: n = 4 houses[][] = [[0, 0], [1, 1], [1, 3], [3, 0]]
Output: 7
Explanation: 
Connect house 1 (0, 0) with house 2 (1, 1) with cost = 2
Connect house 2 (1, 1) with house 3 (1, 3) with cost = 2 
Connect house 1 (0, 0) with house 4 (3, 0) with cost = 3 
The overall minimum cost is 3 + 2 + 2 = 7.
*/



class Solution {
    public int getDistance(int[] u,int[] v)
    {
        return Math.abs(u[0]-v[0])+Math.abs(u[1]-v[1]);
    }
    public int minCost(int[][] houses) {
        // code here
        int n=houses.length;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        boolean[] visited=new boolean[n];
        
        //dist,index
        pq.offer(new int[]{0,0});
        int totalCost=0;
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int ind=curr[1];
            
            if(visited[ind]) continue;
            
            visited[ind]=true;
            totalCost+=curr[0];
            
            for(int v=0;v<n;v++)
            {
                if(!visited[v])
                {
                    int dist=getDistance(houses[ind],houses[v]);
                    pq.add(new int[]{dist,v});
                }
            }
        }
        return totalCost;
    }
}
