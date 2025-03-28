
/*
Prob.: Activity Selection
Difficulty: MediumAccuracy: 36.21%Submissions: 149K+Points: 4Average Time: 20m
You are given a set of activities, each with a start time and a finish time, 
represented by the arrays start[] and finish[], respectively. 
A single person can perform only one activity at a time, meaning no two activities can overlap. 
Your task is to determine the maximum number of activities that a person can complete in a day.

Examples:

Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: A person can perform at most four activities. The maximum set of activities that can be executed is {0, 1, 3, 4}
Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
Output: 1
Explanation: A person can perform at most one activity.
*/


class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n=start.length;
        int ans=0;
        
        PriorityQueue<int[]> p=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        for(int i=0;i<n;i++)
        {
            p.add(new int[]{finish[i],start[i]});
        }
        
        int finishtime=-1;
        
        while(!p.isEmpty())
        {
            int[] activity=p.poll();
            if(activity[1]>finishtime)
            {
                finishtime=activity[0];
                ans++;
            }
        }
        return ans;
    }
}
