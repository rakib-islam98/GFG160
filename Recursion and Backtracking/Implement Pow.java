
/*
Prob.: Implement Pow
Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).
*/


class Solution {
    double power(double b, int e) {
        // code here
        if(e==0) return 1;
        if(e<0) return 1/power(b,-e);
        double temp=power(b,e/2);
        return (e%2==0) ? temp*temp : b*temp*temp;
    }
}
