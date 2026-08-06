class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        int n=nums.length;

        List<List<Integer>> results=new ArrayList<>();

        for(int i=0;i<n-2;i++)
        {
            if(nums[i]>0)
            {
                break;
            }
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }

            int start=i+1;
            int end =n-1;

            int target =-nums[i];

            while(start<end)
            {
                int sum=nums[start]+nums[end];

                if(target==sum)
                {
                    results.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;

                    while(start<end && nums[start]==nums[start-1])
                    {
                        start++;
                    }
                    while(start<end && nums[end]==nums[end+1])
                    {
                        end --;
                    }
                }
                else if(sum<target)
                {
                    start++;
                }
                else
                {
                    end--;
                }
            }
           
        }
         return results;
    }
}
/*  
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



*/