/*
Prob.: Pair with given sum in a sorted array
You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target.
It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 
*/
class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int i=0,j=arr.length-1;
        int cnt=0,ans=0;
        
        while(i<j)
        {
            int sum=arr[i]+arr[j];
            if(sum==target)
            {
                int el1=arr[i],el2=arr[j];
                int cnt1=0,cnt2=0;
                
                while(i<=j && arr[i]==el1)
                {
                    i++;
                    cnt1++;
                }
                while(i<=j && arr[j]==el2)
                {
                    j--;
                    cnt2++;
                }
                
                if(el1==el2) ans+=(cnt1*(cnt1-1))/2;
                else ans+=cnt1*cnt2;
            }
            else if(sum<target) i++;
            else j--;
        }
        return ans;
    }
}
