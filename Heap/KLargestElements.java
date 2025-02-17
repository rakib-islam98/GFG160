
/*
Prob.: k largest elements
Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 
*/

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        Arrays.sort(arr);
        ArrayList<Integer> ans=new ArrayList<>();
        int cnt=0;
        for(int i=arr.length-1;i>=0 && cnt<k;i--)
        {
            ans.add(arr[i]);
            cnt++;
        }
        return ans;
    }
}
