/*
Prob.: Longest Consecutive Subsequence
Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence
such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
*/

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        
        //Min sequence length in case of non empty array with no consecutives is 1
        int longest=1;
        
        //Adding all elements to a HashSet
        HashSet<Integer> hs=new HashSet<>();
        for(int x:arr) hs.add(x);
        
        for(int x:hs)
        {
            //If hs contains an element lesser than that,we'll start counting from that
            if(!hs.contains(x-1))
            {
                int el=x+1;
                int cnt=1;
                //Counting sequence
                while(hs.contains(el))
                {
                    el++;
                    cnt++;
                }
                //Update longest
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
}
