
/*
Prob.: Reverse a linked list
Given the head of a linked list, the task is to reverse this list and return the reversed head.
*/

class Solution {
    Node reverseList(Node head) {
        // code here
        Node curr=head,prev=null,next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
