class Solution {
    public int search(int[] nums, int target)
    {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int guess=-1;



        while(low<=high)
        {
             guess=low+(high-low)/2;

            if(nums[guess]==target)
            {
                return guess;
            } 
            
            if(nums[low]<=nums[guess])
            {
                if(nums[low]<=target && target < nums[guess])
                {
                    high=guess-1;
                }
                else
                {
                    low=guess+1;
                }
            }
            else
            {
                if(nums[guess]<target && target <=nums[high])
                {
                low=guess+1;
                }
                else
                {
                    high=guess-1;
                }
            }
        }    
        return -1;
    }
}