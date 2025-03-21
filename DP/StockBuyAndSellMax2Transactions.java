
/*
Prob.: Stock Buy and Sell – Max 2 Transactions Allowed
In daily share trading, a trader buys shares and sells them on the same day. 
If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.

You are given an array prices[] representing stock prices throughout the day. 
Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).

Examples:

Input: prices[] = [10, 22, 5, 75, 65, 80]
Output: 87
Explanation: 
Trader will buy at 10 and sells at 22. 
Profit earned in 1st transaction = 22 - 10 = 12. 
Then he buys at 5 and sell at 80. 
Profit earned in 2nd transaction = 80 - 5 = 75. 
Total profit earned = 12 + 75 = 87.
*/


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int firstBuy=Integer.MIN_VALUE;
        int firstSell=0;
        int secondBuy=Integer.MIN_VALUE;
        int secondSell=0;
        
        for(int i=0;i<prices.length;i++)
        {
            firstBuy=Math.max(firstBuy,-prices[i]);
            firstSell=Math.max(firstSell,firstBuy+prices[i]);
            secondBuy=Math.max(secondBuy,firstSell-prices[i]);
            secondSell=Math.max(secondSell,secondBuy+prices[i]);
        }
        return secondSell;
    }
}
