
/*
Prob.: Palindrome SubStrings
Given a string s, count all palindromic sub-strings present in the string. 
The length of the palindromic sub-string must be greater than or equal to 2. 

Examples
Input: s = "abaab"
Output: 3
Explanation: All palindromic substrings are : "aba" , "aa" , "baab".
Input: s = "aaa"
Output: 3
Explanation: All palindromic substrings are : "aa", "aa", "aaa".
*/


class Solution {
    int isPalindrome(int i,int j,String s,int[][] memo)
    {
        if(i==j) return 1;
        if(j==i+1 && s.charAt(i)==s.charAt(j)) return 1;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(s.charAt(i)==s.charAt(j) && isPalindrome(i+1,j-1,s,memo)==1)
            memo[i][j]=1;
        else
            memo[i][j]=0;
        return memo[i][j];
    }
    public int countPS(String s) {
        // code here
        int n=s.length();
        
        int[][] memo=new int[n][n];
        for(int[] row:memo)
        {
            Arrays.fill(row,-1);
        }
        
        int res=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(isPalindrome(i,j,s,memo)==1)
                    res++;
            }
        }
        return res;
    }
}
