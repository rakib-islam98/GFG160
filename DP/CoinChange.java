

/*
Prob.: Coin Change (Count Ways)
Given an integer array coins[ ] representing different denominations of currency and an integer sum,
find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. 
Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
*/



class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int n=coins.length;
        int[] dp=new int[sum+1];
        dp[0]=1;
        
        for(int i=0;i<n;i++)
        {
            for(int j=coins[i];j<=sum;j++)
            {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[sum];
    }
}
