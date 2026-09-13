class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stackk = new Stack<>();

        for(int i = 2*n-1; i >= 0; i--) {

            int index = i % n;

            while(!stackk.isEmpty() && stackk.peek() <= nums[index]) {
                stackk.pop();
            }

            if(stackk.isEmpty()) {
                result[index] = -1;
            }
            else {
                result[index] = stackk.peek();
            }

            stackk.push(nums[index]);
        }

        return result;
    }
}