class Solution {
    public int pivotIndex(int[] nums) 
    {
        int totalSum=0;
        for(int num :nums)
        {
            totalSum+=num;
        }
        int left=0;
        for(int i=0;i<nums.length;i++)
        {
            int right=totalSum-left-nums[i];

            if(left==right)
            {
                return i;
            }
            left+=nums[i];  // update AFTER checking, so left always means "sum before i"
        }
        return -1;
        
    }
}