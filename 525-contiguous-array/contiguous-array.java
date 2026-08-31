class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> saveDiff = new HashMap<>();
        saveDiff.put(0, -1);

        int zeros = 0, ones = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }

            int diff = ones - zeros;

            if (saveDiff.containsKey(diff)) {
                int idx = saveDiff.get(diff);
                int length = i - idx;
                result = Math.max(result, length);
            } else {
                saveDiff.put(diff, i);
            }
        }

        return result;
    }
}