
/*
Prob.: Add Number Linked Lists
Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
*/


class Solution {
    static Node reverse(Node head)
    {
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
    static Node trimLeadingZeroes(Node head)
    {
        while(head!=null && head.data==0)
        {
            head=head.next;
        }
        return head;
    }
    static Node addTwoLists(Node num1, Node num2) {
        // code 
        if(num1==null) return num2;
        if(num2==null) return num1;
        
        num1=reverse(num1);
        num2=reverse(num2);
        
        Node res=num1;
        Node prev=null;
        int c=0,sum;
        
        while(num1!=null && num2!=null)
        {
            sum=num1.data+num2.data+c;
            num1.data=sum%10;
            c=sum/10;
            prev=num1;
            num1=num1.next;
            num2=num2.next;
        }
            
        if(num1!=null || num2!=null)
        {
            if(num2!=null)
                prev.next=num2;
                num1=prev.next;
                while(num1!=null)
                {
                    sum=c+num1.data;
                    num1.data=sum%10;
                    c=sum/10;
                    prev=num1;
                    num1=num1.next;
                }
        }
        if(c>0) prev.next=new Node(c);
            
        res=reverse(res);
        return trimLeadingZeroes(res);
    }
}
