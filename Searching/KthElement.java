class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n=a.length,m=b.length;
        int ind=k,lastElement=0;
        
        int i=0,j=0;
        while(k-->0)
        {
            if(i<n)
            {
                if(j<m && a[i]>b[j])
                {
                    lastElement=b[j];
                    j++;
                }
                else
                {
                    lastElement=a[i];
                    i++;
                }
                
            }
            else if(j<m)
            {
                lastElement=b[j];
                j++;
            }
        }
        return lastElement;
    }
}
