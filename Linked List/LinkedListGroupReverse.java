
/*
Prob.: Linked List Group Reverse
Given the head a linked list, the task is to reverse every k node in the linked list.
If the number of nodes is not a multiple of k then the left-out nodes in the end,
should be considered as a group and must be reversed.
*/


class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        Stack<Node> st=new Stack<>();
        Node curr=head;
        Node prev=null;
        
        while(curr!=null)
        {
            int cnt=0;
            while(curr!=null && cnt<k)
            {
                st.push(curr);
                curr=curr.next;
                cnt++;
            }
            while(!st.isEmpty())
            {
                if(prev==null)
                {
                    prev=st.pop();
                    head=prev;
                }
                else
                {
                    prev.next=st.pop();
                    prev=prev.next;
                }
            }
        }
        prev.next=null;
        return head;
    }
}
