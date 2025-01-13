
/*
Prob.: Container With Most Water
Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines,
find the maximum amount of water that can be contained between any two lines, together with the x-axis.

Note: In the case of a single vertical line it will not be able to hold water.
*/

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int n=arr.length;
        if(n==0 && n==1) return 0;
        
        int i=0,j=n-1,maxWater=0;
        while(i<j)
        {
            int currWater=Math.min(arr[i],arr[j])*(j-i);
            maxWater=Math.max(maxWater,currWater);
            if(arr[i]<arr[j]) i++;
            else j--;
        }
        return maxWater;
    }
}
