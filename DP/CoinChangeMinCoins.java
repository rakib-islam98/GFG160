
/*
Prob.: Coin Change (Minimum Coins)
You are given an array coins[], where each element represents a coin of a different denomination, 
and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

Examples:

Input: coins[] = [25, 10, 5], sum = 30
Output: 2
Explanation: Minimum 2 coins needed, 25 and 5  
*/



class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int [][] dp=new int[coins.length][sum+1];
        
        for(int i=coins.length-1;i>=0;i--)
        {
            for(int j=1;j<=sum;j++)
            {
                dp[i][j]=Integer.MAX_VALUE;
                int take=Integer.MAX_VALUE, noTake=Integer.MAX_VALUE;
                
                if(j-coins[i]>=0)
                {
                    take=dp[i][j-coins[i]];
                    if(take!=Integer.MAX_VALUE) take++;
                }
                if(i+1<coins.length) noTake=dp[i+1][j];
                dp[i][j]=Math.min(take,noTake);
            }
        }
        if(dp[0][sum]!=Integer.MAX_VALUE) return dp[0][sum];
        return -1;
    }
}
