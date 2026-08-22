class Solution {
    public int maxSubarraySumCircular(int[] nums) 
    {
        int totalSum=0;
        int maxSum=nums[0];
        int minSum=nums[0];
        int currMax=0;
        int currMin=0;

        for(int i : nums)
        {   
            currMax=Math.max(currMax + i, i);
            maxSum=Math.max(maxSum,currMax);

            currMin=Math.min(currMin + i , i);
            minSum=Math.min(minSum , currMin);

            totalSum+=i;

        }
        if(maxSum<0)
        {
            return maxSum;
        }

    return Math.max(maxSum , totalSum-minSum);
    }
}