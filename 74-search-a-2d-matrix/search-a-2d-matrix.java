class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int total = matrix.length * matrix[0].length;
       
        int coloumns=matrix[0].length;

        int low =0;
        int high=total-1;

        while(low<=high)
        {
            int guess=low+(high-low)/2;
            int i=guess/coloumns;
            int j=guess%coloumns;
            if(matrix[i][j]==target)
            {
                return true;
            }
            else if(matrix[i][j]<target)
            {
                low=guess+1;
            }
            else
            {
                high=guess-1;
            }
        }
        return false;
    }
}