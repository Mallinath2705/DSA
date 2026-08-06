class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer>duplicate=new HashSet<>();

        for(int num :nums)
        {
            if(!duplicate.add(num))
            {
                return true;
            }
        }
        return false;
        
        
    }
}








//Mine ACCCEPTED solution

// class Solution {
//     public boolean containsDuplicate(int[] nums) 
//     {
//         Arrays.sort(nums);
//         int left=0;
//         int right=left+1;
    
//         while(left<right && right<nums.length)
//         {
//             if(nums[left]==nums[right])
//             {
//                 return true;
//             }
//             else
//             {
//                 left++;
//                 right++;
//             }
//         }    
//         return false;
//     }
// }