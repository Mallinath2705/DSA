

class Solution {

    public int multiplication(int n)
{
     int sum=0;
    while(n>0)
    {
       
    int ress=n%10;
    sum=sum+ress*ress;
    n=n/10;
    }
    return sum;
}
    public boolean isHappy(int n) 
    {
        int slow=n;
        int fast=n;

        while(fast !=1)
        {
            slow=multiplication(slow);
            fast=multiplication(fast);
            fast=multiplication(fast);

            if(slow==fast && slow!=1)
            {
                return false;
            }
        }    
        return true;
    }
}