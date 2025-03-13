
/*
Prob.: 0 - 1 Knapsack Problem
Given n items, each with a specific weight and value, and a knapsack with a capacity of W, 
the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
*/


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int[] dp=new int[W+1];
        
        for(int i=1;i<=wt.length;i++)
        {
            for(int j=W;j>=wt[i-1];j--)
            {
                dp[j]=Math.max(dp[j],dp[j-wt[i-1]]+val[i-1]);
            }
        }
        return dp[W];
    }
}
