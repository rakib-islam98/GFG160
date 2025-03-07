
/*
Prob.: Longest Common Subsequence
Difficulty: MediumAccuracy: 41.68%Submissions: 305K+Points: 4
Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.

A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. 
For example, "ABE" is a subsequence of "ABCDE".
*/


class Solution {
    static int lcs(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        
        int[][] dp=new int [n+1][m+1];
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(s1.charAt(i)==s2.charAt(j))
                {
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
