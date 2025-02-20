

/*
Prob.: Find median in a stream
Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

There are two cases for median on the basis of data set size.

1. If the data set has an odd number then the middle one will be consider as median.
2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.
*/


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> ans=new ArrayList<>();
        //We need two subpart leftMin(maxHeap) and rightMax(minHeap)
        PriorityQueue<Integer> leftMin=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> rightMax=new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++)
        {
            //we add to max part
            rightMax.add(arr[i]);
            //now we need to move top element from max to min to maintain order left<=right
            leftMin.add(rightMax.poll());
            
            //to maintain height balance we need to move again
            if(leftMin.size()>rightMax.size())
            {
                rightMax.add(leftMin.poll());
            }
            if(leftMin.size()!=rightMax.size())
                ans.add((double)rightMax.peek());
            else
            {
                ans.add((rightMax.peek()+leftMin.peek())/2.0);
            }
            
        }
        // ans.add((double)arr[0]);
        
        // for(int i=1;i<arr.length;i++)
        // {
        //     int x=arr[i];
        //     int j=i-1;
        //     while(j>=0 && arr[j]>x)
        //     {
        //         arr[j+1]=arr[j];
        //         j--;
        //     }
        //     arr[j+1]=x;
            
        //     int sortedLength=i+1;
        //     double currMedian;
        //     if(sortedLength%2==0)
        //         currMedian=(arr[sortedLength/2-1]+arr[sortedLength/2])/2.0;
        //     else currMedian=arr[sortedLength/2];
            
        //     ans.add(currMedian);
        // }
        
        return ans;
    }
}
