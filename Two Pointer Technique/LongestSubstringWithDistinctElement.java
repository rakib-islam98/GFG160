
/*
Prob.: Longest substring with distinct characters
Given a string s, find the length of the longest substring with all distinct characters. 
*/

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int maxLen=Integer.MIN_VALUE;
        boolean visited[]=new boolean[26];
        
        int i=0,j=0;
        while(j<s.length())
        {
            while(visited[s.charAt(j)-'a']==true)
            {
                visited[s.charAt(i)-'a']=false;
                i++;
            }
            visited[s.charAt(j)-'a']=true;
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}
