/*
Prob.: Count Pairs whose sum is less than target
Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.
*/

class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        int cnt=0;
        while(i<j)
        {
            int sum=arr[i]+arr[j];
            if(sum<target)
            {
                cnt+=j-i;
                i++;
            }
            else j--;  
        }
        return cnt;
    }
}
