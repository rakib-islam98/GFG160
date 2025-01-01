/*
Print Anagrams Together
Given an array of strings, return all groups of strings that are anagrams.
The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.
Note: The final output will be in lexicographic order.
*/

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> hm=new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            char[] chars=arr[i].toCharArray();
            Arrays.sort(chars);
            String str=new String(chars);
            
            if(hm.containsKey(str))
            {
                hm.get(str).add(arr[i]);
            }
            else
            {
                ArrayList<String> temp=new ArrayList<>();
                temp.add(arr[i]);
                hm.put(str,temp);
            }
        }
        for(Map.Entry<String,ArrayList<String>> e:hm.entrySet())
        {
            ans.add(e.getValue());
        }
        return ans;
    }
}
