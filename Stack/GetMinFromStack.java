
/*
Prob.: Get Min from Stack
Given q queries, You task is to implement the following four functions for a stack:

push(x) – Insert an integer x onto the stack.
pop() – Remove the top element from the stack.
peek() - Return the top element from the stack. If the stack is empty, return -1.
getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
Each query can be one of the following:

1 x : Push x onto the stack.
2 : Pop the top element from the stack.
3: Return the top element from the stack. If the stack is empty, return -1.
4: Return the minimum element from the stack.
*/


class Solution {
    public Solution() {}

    Stack<Integer> stack=new Stack<>();
    int min;
    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if(stack.isEmpty())
        {
            min=x;
        }
        else if(x<=min)
        {
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(stack.isEmpty()) return;
        int temp=stack.pop();
        if(temp==min && !stack.isEmpty())
        {
            min=stack.peek();
            stack.pop();
        }
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if(stack.isEmpty()) return -1;
        return min;
    }
}
