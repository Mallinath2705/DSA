class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int MaxEnd=0;
        int MinEnd=0;
        int MaxSum=Integer.MIN_VALUE;
        int MinSum=Integer.MAX_VALUE;
        for(int i : nums)
        {   
            MaxEnd=Math.max(MaxEnd+i , i );
            MaxSum=Math.max(MaxEnd , MaxSum);

            MinEnd=Math.min(MinEnd+i , i);
            MinSum=Math.min(MinEnd , MinSum);

        }
        return Math.max(Math.abs(MaxSum), Math.abs(MinSum));
    }
}