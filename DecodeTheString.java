
/*
Prob.: Decode the string
Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets.
Note: The test cases are generated so that the length of the output string will never exceed 105 .
*/


class Solution {
    static String decodeString(String s) {
        // code here
        StringBuilder res=new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=']')
            {
                res.append(s.charAt(i));    //res=3[b2[ca
            }
            else
            {
                StringBuilder temp=new StringBuilder("");
                while(res.length()>0 && res.charAt(res.length()-1)!='[')
                {
                    temp.insert(0,res.charAt(res.length()-1));
                    res.deleteCharAt(res.length()-1);
                }
                //Delete '[' symbol
                res.deleteCharAt(res.length()-1);  //res=3[b2  temp=ca
                
                StringBuilder num=new StringBuilder();
                while(res.length()>0 && Character.isDigit(res.charAt(res.length()-1)))
                {
                    num.insert(0,res.charAt(res.length()-1));
                    res.deleteCharAt(res.length()-1);
                }
                // res=3[b temp=ca num=2
                int k=Integer.parseInt(num.toString());
                for(int j=0;j<k;j++)
                {
                    res.append(temp);
                }
                //res=3[bcaca
            }
        }
        return res.toString();
    }
}
