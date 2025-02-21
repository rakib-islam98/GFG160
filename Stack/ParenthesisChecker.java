
/*
Prob.: Parenthesis Checker
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.
*/


class Solution {
    static boolean isBalanced(String s) {
        // code here
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            if(curr=='['||curr=='{'||curr=='(')
                stack.push(curr);
            else
            {
                if(stack.isEmpty()) return false;
                char top=stack.peek();
                if((top=='('&&curr==')') || (top=='{'&&curr=='}') || (top=='['&&curr==']')) 
                    stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
