
/*
Prob.: Permutations of a String
Given a string s, which may contain duplicate characters, your task is to generate and 
return an array of all unique permutations of the string. You can return your answer in any order.
*/


class Solution {
    public void swap(char arr[],int i,int j)
    {
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void getPermutation(int i,int n,char arr[],HashSet<String> permutation)
    {
        if(i==n)
        {
            permutation.add(new String(arr));
            return;
        }
        for(int j=i;j<n;j++)
        {
            swap(arr,i,j);
            getPermutation(i+1,n,arr,permutation);
            swap(arr,i,j);
        }
    }
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> permutation=new HashSet<>();
        char arr[]=s.toCharArray();
        getPermutation(0,s.length(),arr,permutation);
        ArrayList<String> result=new ArrayList<>(permutation);
        Collections.sort(result);
        return result;
    }
}
