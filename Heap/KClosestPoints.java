
/*
Prob.: K Closest Points to Origin
Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance, defined as: 

sqrt( (x2 - x1)2 + (y2 - y1)2 )

Note: You can return the k closest points in any order, driver code will sort them before printing.
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        int[][] closet=new int[k][];
        PriorityQueue<int[]> pq=new PriorityQueue<>
                ((a,b)-> Integer.compare(getDistance(b),getDistance(a)));
        
        for(int[] point:points)
        {
            if(pq.size()<k) pq.add(point);
            else
            {
                if(getDistance(point)<getDistance(pq.peek()))
                {
                    pq.poll();
                    pq.add(point);
                }
            }
        }
        
        for(int i=0;i<k;i++)
        {
            closet[i]=pq.poll();
        }
        return closet;
    }
    
    public int getDistance(int[] point)
    {
        return (point[0]*point[0] + point[1]*point[1]);
    }
}
