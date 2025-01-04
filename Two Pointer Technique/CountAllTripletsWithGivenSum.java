/*
Prob.: Count all triplets with given sum in sorted array
Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices,
such that arr[i] + arr[j] + arr[k] = target and i < j < k.
*/

class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n-2;i++)
        {
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==target)
                {
                   if (arr[j] == arr[k]) 
                   {
                        cnt += (num * (num - 1)) / 2;
                        break; // Break because no more valid pairs for this i
                   }
                   int left=1,right=1;
                   while(j+1<k && arr[j]==arr[j+1])
                   {
                       j++;
                       left++;
                   }
                   while(k-1>j && arr[k]==arr[k-1])
                   {
                       k--;
                       right++;
                   }
                   cnt+=left*right;
                   j++;k--;
                } 
                else if(sum<target) j++;
                else k--;
            }
        }
        return cnt;
    }
}
