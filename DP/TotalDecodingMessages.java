

/*
Prob.: Total Decoding Messages
A message containing letters A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

You are given a string digits. You have to determine the total number of ways that message can be decoded.

Examples:

Input: digits = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(1, 2, 3), "LC"(12, 3) and "AW"(1, 23).
Input: digits = "90"
Output: 0
Explanation: "90" cannot be decoded, as it's an invalid string and we cannot decode '0'.
*/

class Solution {
    public int countWays(String digits) {
        // code here
        int n=digits.length();
        
        if(n==0 || digits.charAt(0)=='0')
            return 0;
        
        int prev1=1,prev2=0;
        for(int i=1;i<=n;i++)
        {
            int current=0;
            if(digits.charAt(i-1)!='0')
            {
                current+=prev1;
            }
            if(i>1)
            {
                int twoDigit=(digits.charAt(i-2)-'0')*10
                                +(digits.charAt(i-1)-'0');
                if(twoDigit>=10 && twoDigit<=26)
                    current+=prev2;
            }
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}
