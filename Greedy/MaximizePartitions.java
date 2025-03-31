
/*
Prob.: Maximize partitions in a String
Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, 
after possible partitions (probably zero) of s such that no two substrings have a common character.

Examples:

Input: s = "acbbcc"
Output: 2
Explanation: "a" and "cbbcc" are two substrings that do not share any characters between them.
Input: s = "ababcbacadefegdehijhklij"
Output: 3
Explanation: Partitioning at the index 8 and at 15 produces three substrings: “ababcbaca”, “defegde”, and “hijhklij” 
such that none of them have a common character. So, the maximum number of substrings formed is 3.
*/


class Solution {
    public int maxPartitions(String s) {
        // code here
        int[] first=new int[26],last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        
        for(int i=0;i<s.length();i++)
        {
            if(first[s.charAt(i)-'a']==-1)
                first[s.charAt(i)-'a']=i;
            last[s.charAt(i)-'a']=i;
        }
        int count=0;
        int end=0;
        
        for(int i=0;i<s.length();i++)
        {
            end=Math.max(end,last[s.charAt(i)-'a']);
            
            if(i==end)
                count++;
        }
        
        return count;
    }
}
