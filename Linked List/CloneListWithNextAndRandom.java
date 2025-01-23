
/*
Prob.: Clone List with Next and Random
You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list,
and a random pointer that points to the random node of the linked list.

Construct a copy of this linked list. The copy should consist of the same number of new nodes,
where each new node has the value corresponding to its original node. Both the next and
random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state.
None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.
*/


class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if(head==null) return head;
        Node temp=head;
        //Copying the ll
        while(temp!=null)
        {
            Node newNode=new Node(temp.data);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=newNode.next;
        }
        temp=head;
        Node head2=temp.next;
        //Copying random
        while(temp!=null)
        {
            if(temp.random==null)
                temp.next.random=null;
            else
                temp.next.random=temp.random.next;
            temp=temp.next.next;
        }
        //modify new list next pointer
        temp=head;
        while(temp!=null)
        {
            Node temp2=temp.next;
            temp.next=temp2.next;
            if(temp2.next!=null)
                temp2.next=temp2.next.next;
            temp=temp.next;
        }
        return head2;
    }
}
