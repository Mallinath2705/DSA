class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: find the largest index `i` such that nums[i] < nums[i+1]
        // (i.e., the first "break point" from the right where ascending order breaks)
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: if such an index exists, find the largest index `j` > i
        // such that nums[j] > nums[i], and swap them
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: reverse the suffix starting at i+1 to get the smallest 
        // possible arrangement of that suffix (it's currently in descending order)
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}