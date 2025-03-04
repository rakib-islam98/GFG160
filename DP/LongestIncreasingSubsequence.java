
/*
Prob.: Longest Increasing Subsequence
Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
*/



class Solution {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        int[] lis=new int[n];
        Arrays.fill(lis,1); 
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]<arr[j])
                {
                    lis[i]=Math.max(lis[i],1+lis[j]);
                }
            }
        }
        // for (int x:lis)
        // System.out.print(x+" ");
        // System.out.println();
        int max=-1;
        for(int x:lis)
            max=Math.max(max,x);
            
        return max;
    }
}
