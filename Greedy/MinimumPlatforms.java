

/*
Prob.: Minimum Platforms
You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the same day.
Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.

At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. 
Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are required to accommodate both trains.

Examples:

Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.
Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train times are mutually exclusive. So we need only one platform
*/

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=0,j=0;
        int cnt=0,maxCnt=0;
        
        while(i<arr.length)
        {
            if(arr[i]<=dep[j])
            {
                cnt++;
                i++;
            }
            else
            {
                cnt--;
                j++;
            }
            maxCnt=Math.max(maxCnt,cnt);
        }
        return maxCnt;
    }
}
