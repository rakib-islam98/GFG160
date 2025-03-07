
/*
Prob.: Longest String Chain
You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in 
wordA without changing the order of the other characters to make it equal to wordB. For example, 
"abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, 
word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.

Return the length of the longest possible word chain with words chosen from the given list of words in any order.

Examples:

Input: words[] = ["ba", "b", "a", "bca", "bda", "bdca"]
Output: 4
Explanation: One of the longest word chains is ["a", "ba", "bda", "bdca"].
*/


class Solution {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words,(a,b)->a.length()-b.length());
        HashMap<String,Integer> dp=new HashMap<>();
        
        int res=1;
        for(String w:words)
        {
            dp.put(w,1);
            for(int i=0;i<w.length();i++)
            {
                String pred=w.substring(0,i)+w.substring(i+1);
                if(dp.containsKey(pred))
                {
                    dp.put(w,Math.max(dp.get(w),dp.get(pred)+1));
                }
                res=Math.max(res,dp.get(w));
            }
        }
        return res;
    }
}
