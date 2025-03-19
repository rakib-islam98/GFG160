
/*
Prob.: Stock Buy and Sell – Max K Transactions Allowed
In the stock market, a person buys a stock and sells it on some future date. 
You are given an array prices[] representing stock prices on different days and a positive integer k, 
find out the maximum profit a person can make in at-most k transactions.

A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.

Examples :
Input: prices[] = [10, 22, 5, 80], k = 2
Output: 87
Explaination:
1st transaction: Buy at 10 and sell at 22. 
2nd transaction : Buy at 5 and sell at 80.
Total Profit will be 12 + 75 = 87.

Input: prices[] = [20, 580, 420, 900], k = 3
Output: 1040
Explaination: 
1st transaction: Buy at 20 and sell at 580. 
2nd transaction : Buy at 420 and sell at 900.
Total Profit will be 560 + 480 = 1040.

Input: prices[] = [100, 90, 80, 50, 25],  k = 1
Output: 0
Explaination: Selling price is decreasing continuously
leading to loss. So seller cannot have any profit.
*/


class Solution {
    static int maxProfit(int prices[], int k) {
        // code here
        int n=prices.length;
        if(n==0 || k==0) return 0;
        
        int[][] curr=new int[k+1][2];
        int[][] next=new int[k+1][2];
        
        for(int i=n-1;i>=0;i--)
        {
            for(int l=1;l<=k;l++)
            {
                curr[l][1]=Math.max(-prices[i]+next[l][0],next[l][1]);
                curr[l][0]=Math.max(prices[i]+next[l-1][1],next[l][0]);
            }
            for(int l=0;l<=k;l++)
            {
                next[l][0]=curr[l][0];
                next[l][1]=curr[l][1];
            }
        }
        return curr[k][1];
    }
}
