
/*
Prob.: Job Sequencing Problem
You are given two arrays: deadline[], and profit[], which represent a set of jobs, 
where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, 
and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:

The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.
Examples :

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
*/


class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        ArrayList<int[]> jobs=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            jobs.add(new int[]{deadline[i],profit[i]});
        }
        
        jobs.sort((a,b)->Integer.compare(b[1],a[1]));
        
        int maxDeadline=0;
        for(int x:deadline)
        {
            maxDeadline=Math.max(maxDeadline,x);
        }
        
        int[] slot=new int[maxDeadline];
        
        int tp=0,cnt=0;
        for(int i=0;i<n;i++)
        {
            int currDeadline=jobs.get(i)[0]-1;
            int currProfit=jobs.get(i)[1];
            
            for(int j=currDeadline;j>=0;j--)
            {
                if(slot[j]==0)
                {
                    slot[j]=1;
                    tp+=currProfit;
                    cnt++;
                    break;
                }
            }
        }
        return new ArrayList<>(List.of(cnt,tp));
    }
}
