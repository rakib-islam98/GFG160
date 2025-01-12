
/*
Prob.: Trapping Rain Water
Given an array arr[] with non-negative integers representing the height of blocks. 
If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
*/

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int leftMax=arr[0];
        int rightMax=arr[arr.length-1];
        int left=1,right=arr.length-2;
        
        int ans=0;
        while(left<=right)
        {
            if(rightMax<leftMax)
            {
                ans+=Math.max(rightMax-arr[right],0);
                rightMax=Math.max(rightMax,arr[right]);
                right--;
            }
            else
            {
                ans+=Math.max(leftMax-arr[left],0);
                leftMax=Math.max(arr[left],leftMax);
                left++;
            }
        }
        return ans;
    }
}
