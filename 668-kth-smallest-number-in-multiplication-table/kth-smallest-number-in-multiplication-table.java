class Solution {
    int helperfunction(int guess, int m, int n)
{
    int count = 0;
    int rows = m - 1;
    int coloumns = 0;

    while(rows >= 0 && coloumns <= n - 1)
    {
        int value = (rows + 1) * (coloumns + 1);

        if(value <= guess)
        {
            count = count + rows + 1;
            coloumns++;
        }
        else
        {
            rows--;
        }
    }

    return count;
}
    public int findKthNumber(int m, int n, int k) 
    {
        int low=0;
        int high=m*n;
        int res=0;
       

        while(low<=high)
        {
            int guess=low+(high-low)/2;
            int count=helperfunction(guess , m ,n);
            if(count<k)
            {
                low=guess+1;
            }
            else
            {
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
}