
/*
Prob.: Rotate a Linked List
Given the head of a singly linked list, your task is to left rotate the linked list k times.
*/

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(k==0 || head==null)
            return head;
        //Calculating size of the linked list
        Node curr=head;
        int size=1;
        while(curr.next!=null)
        {
            curr=curr.next;
            size++;
        }
        //calculationg the exact rotation
        k%=size;
        //if k=0 then return 
        if(k==0) return head;
        //link last element to the head and 1 shifting done out of k
        curr.next=head;
        curr=head;
        for(int i=1;i<k;i++)
        {
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
}
