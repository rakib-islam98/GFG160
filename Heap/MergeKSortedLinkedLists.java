
/*
Prob.: Merge K sorted linked lists
Given an array arr[] of n sorted linked lists of different sizes. 
The task is to merge them in such a way that after merging they will be a single sorted linked list, 
then return the head of the merged linked list.
*/

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)-> a.data-b.data);
        for(Node node:arr)
            pq.add(node);
            
        Node temp=new Node(-1);
        Node last=temp;
        
        while(!pq.isEmpty())
        {
            Node min=pq.poll();
            last.next=min;
            last=min;
            
            if(last.next!=null)
                pq.add(last.next);

        }
        return temp.next;
    }
}
