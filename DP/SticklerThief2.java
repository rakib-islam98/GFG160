
/*
Prob.: Stickler Thief II
You are given an array arr[] which represents houses arranged in a circle, 
where each house has a certain value. A thief aims to maximize the total stolen value without robbing two adjacent houses.
Determine the maximum amount the thief can steal.

Note: Since the houses are in a circle, the first and last houses are also considered adjacent.

Examples:

Input: arr[] = [2, 3, 2]
Output: 3
Explanation: arr[0] and arr[2] can't be robbed because they are adjacent houses. Thus, 3 is the maximum value thief can rob.
*/


class Solution {
    static int maxValTab(int x,int y,int[] arr)
    {
        int n=arr.length;
        int prev2=arr[x];
        int prev1=Math.max(arr[x],arr[x+1]);
        
        for(int j=x+2;j<=y;j++)
        {
            int take=arr[j]+prev2;
            int noTake=prev1;
            
            int curr=Math.max(take,noTake);
            prev2=prev1;
            prev1=curr;
        }
            
        return prev1;
    }
    int maxValue(int[] arr) {
        // code here
        int n=arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];
        
        int ans=0;
        
        ans=Math.max(ans,maxValTab(0,n-2,arr));
        ans=Math.max(ans,maxValTab(1,n-1,arr));
        
        return ans;
    }
}
