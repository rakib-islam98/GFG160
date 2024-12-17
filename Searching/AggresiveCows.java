/*
Prob.: Aggressive Cows
You are given an array with unique elements of stalls[], which denote the position of a stall. 
You are also given an integer k which denotes the number of aggressive cows. 
Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.
*/

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n=stalls.length;
        Arrays.sort(stalls);
        //Minimum distance can be 1 and maximum distance can be stalls[n-1]-stalls[0]
        int l=1,h=stalls[n-1]-stalls[0];
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(placeCow(stalls,mid,k)) l=mid+1;
            else h=mid-1;
        }
        return h;
    }
    //placeCow Function
    public static boolean placeCow(int[] stalls,int dist,int k)
    {
        int cowCnt=1,last=stalls[0];    //1st cow is placed at 0th stall
        for(int i=1;i<stalls.length;i++)
        {
            if(stalls[i]-last>=dist)
            {
                last=stalls[i]; //last stalls position where last cow is placed
                cowCnt++;
            }
            //IF all cows are placed
            if(cowCnt==k) return true;
        }
        return false;
    }
}
