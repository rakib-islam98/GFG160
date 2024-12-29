/*
Prob.: Intersection of Two arrays with Duplicate Elements
Given two integer arrays a[] and b[], you have to find the intersection of the two arrays.
Intersection of two arrays is said to be elements that are common in both arrays. 
The intersection should not have duplicate elements and the result should contain items in any order.
Note: The driver code will sort the resulting array in increasing order before printing.
*/

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        HashSet<Integer> setA=new HashSet<>();
        
        for(int x:a) setA.add(x);
        for(int x:b)
        {
            if(setA.contains(x))
            {
                ans.add(x);
                setA.remove(x);
            }
        }
        return ans;
    }
}
