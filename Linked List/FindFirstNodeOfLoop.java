
/*
Prob.: Find the first node of loop in linked list
Given a head of the singly linked list. If a loop is present in the list then return the first node of the loop else return NULL.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. 
If pos = 0, it means the last node points to null, indicating there is no loop.
*/


class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        Node fast=head,slow=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                slow=head;
                while(fast!=slow)
                {
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
