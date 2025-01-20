
/*
Prob.: Merge two sorted linked lists
Given the head of two sorted linked lists consisting of nodes respectively. 
The task is to merge both lists and return the head of the sorted merged list.
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        //Better using recursion
        
        // if(head1==null) return head2;
        // if(head2==null) return head1;
        // if(head1.data<=head2.data)
        // {
        //     head1.next=sortedMerge(head1.next,head2);
        //     return head1;
        // }
        // else
        // {
        //     head2.next=sortedMerge(head1,head2.next);
        //     return head2;
        // }
        
        //Create a temporary node and initially curr point to temp node
        Node temp=new Node(-1);
        Node curr=temp;
        
        //Until any of one list is elapsed, we'll iterate and add to the current list
        while(head1!=null && head2!=null)
        {
            //Compare head1 and head2 data and add to current
            if(head1.data<=head2.data)
            {
                curr.next=head1;
                head1=head1.next;
            }
            else
            {
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
        //Add any remaining list to the curr list
        if(head1==null)
        {
            curr.next=head2;
        }
        else curr.next=head1;
        //bcz first node is a dummy one
        return temp.next;
    }
}
