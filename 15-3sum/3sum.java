    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n=nums.length;

            List<List<Integer>> res= new ArrayList<>();
            for(int i=0;i<n-2;i++)
            {
                if(nums[i]>0)
                {
                    break;
                }
                if(i >0 && nums[i]==nums[i-1])
                {
                    continue;
                }

                int left=i+1;
                int right=n-1;
                //  ith apan target shi match honare pairs hudkayche ahet na so mg ata apan 
                // nums[i]+nums[left]+nums[right]==0 asa check karnr na tr mg ata 
                //  nums[i] la RHS la pathvych so the equation will be 
                // nums[left]+nums[right]== -nums[i] so ata target mhnun he use krnae aapan 

                int target= -nums[i];

                while(left<right)
                {
                    int sum=nums[left]+nums[right];

                    if(target==sum)
                    {
                        res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;


                        while(left<right && nums[left]==nums[left-1])
                        {
                            left++;
                        }
                        while(left<right  && nums[right]==nums[right+1])
                        {
                            right--;
                        }
                    }

                    else if(sum<target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }

                }

            }
            return res;
        }
    }


/*

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            // sorted array: if smallest element > 0, no triplet can sum to 0
            if (nums[i] > 0) break;

            // skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}

*/ 