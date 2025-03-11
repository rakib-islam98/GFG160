

/*
Prob.: Ways to Reach the n'th Stair
Difficulty: MediumAccuracy: 21.9%Submissions: 217K+Points: 4
There are n stairs, a person standing at the bottom wants to reach the top. 
The person can climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, 
the person can reach the top (order does matter).

Examples:

Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair. 
Input: n = 2
Output: 2
Explanation: There are 2 ways to reach 2th stair: {1, 1} and {2}. 
*/


class Solution {
    int countWays(int n) {
        // your code here
        int prev1=1,prev2=1;
        
        for(int i=2;i<=n;i++)
        {
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
