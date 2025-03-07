
/*
Prob.: Longest Palindromic Subsequence
Difficulty: MediumAccuracy: 56.57%Submissions: 98K+Points: 4
Given a string s, return the length of the longest palindromic subsequence.

A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

A palindromic sequence is a sequence that reads the same forward and backward.

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
*/

class Solution {
    public int longestPalinSubseq(String s) {
        // code here
        String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        
        int[][] dp=new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(s.charAt(i)==rev.charAt(j))
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
