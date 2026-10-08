class Solution {

    private boolean canSplit(int[] nums, int k, long maxSum) {

        int parts = 1;
        long currentSum = 0;

        for (int num : nums) {

            if (currentSum + num <= maxSum) {
                currentSum += num;
            }
            else {
                parts++;
                currentSum = num;

                if (parts > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {

        long low = 0;
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                // mid possible आहे.
                // अजून कमी maximum sum मिळतोय का पाहू.
                high = mid;
            }
            else {
                // mid मध्ये k parts मध्ये split करता येत नाही.
                low = mid + 1;
            }
        }

        return (int) low;
    }
}