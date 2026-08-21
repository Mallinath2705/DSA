class Solution {
    public int maximumSum(int[] arr) 
    {
        int previousWithDelete = arr[0];
        int previousWithNoDelete = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++)
        {
            // save old previousWithNoDelete BEFORE overwriting it,
            // since previousWithDelete's transition depends on the OLD value
            int oldPreviousWithNoDelete = previousWithNoDelete;

            previousWithDelete = Math.max(previousWithDelete + arr[i], oldPreviousWithNoDelete);
            previousWithNoDelete = Math.max(oldPreviousWithNoDelete + arr[i], arr[i]);

            int current = Math.max(previousWithDelete, previousWithNoDelete);

            max = Math.max(current, max);
        }    
        return max;
    }
}