
/*
Prob.: Evaluation of Postfix Expression
Difficulty: MediumAccuracy: 63.04%Submissions: 103K+Points: 4
You are given an array of strings arr that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.

Key Details:

The valid operators are '+', '-', '*', and '/'.
Each operand is guaranteed to be a valid integer or another expression.
The division operation between two integers always rounds the result towards zero, discarding any fractional part.
No division by zero will occur in the input.
The input is a valid arithmetic expression in Reverse Polish Notation.
The result of the expression and all intermediate calculations will fit in a 32-bit signed integer.
*/


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].matches("-?[0-9]+"))
            {
                int val=Integer.parseInt(arr[i]);
                stack.push(val);
            }
            else
            {
                int val2=stack.pop();
                int val1=stack.pop();
                
                switch(arr[i])
                {
                    case "+": stack.push(val1+val2);
                            break;
                    case "-": stack.push(val1-val2);
                            break;
                    case "*": stack.push(val1*val2);
                            break;
                    case "/": stack.push(val1/val2);
                            break;
                }
            }
        }
        
        return stack.peek();
    }
}
