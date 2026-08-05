class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer , Integer> newnums=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
        int complement=target-nums[i];  //complement mhnje target 9 ahe and curr ele 2 ahe tr mg 9-2=7 tr mg 7 ahe ka arr madhe te check krtay

        if(newnums.containsKey(complement))  // jr complement key tya map valya arr madhe asli tr true houn index return kel
        {
            return new int[]{newnums.get(complement) , i};
        }
            newnums.put(nums[i],i);
        }

        return new int[] {-1,-1};
    }
}


// class Solution {
//     public int[] twoSum(int[] nums, int target) {

//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     return new int[] { i, j };
//                 }
//             }
//         }

//         return new int[] { -1, -1 };
//     }
// }