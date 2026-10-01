class Solution {
    int howmuchelement(int[][]matrix,int guess, int m , int n)
    {
        int r=n-1;
        int c=0;
        int count=0;
       while(r>=0 && c <= m-1)
       {
        if(matrix[r][c]<=guess)
        {
            count=count+r+1;
            c++;
        }
        else
        {
            r--;
        }
        
       }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) 
    {
    int n=matrix.length;
    int m=matrix[0].length;

    int low=matrix[0][0];
    int high=matrix[n-1][m-1];
    int res=-1;
    while(low<=high)
    {
        int guess=low+(high-low)/2;
        int ans=howmuchelement(matrix,guess,m,n);
        if(ans<k)
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