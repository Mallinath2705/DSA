class Solution {
    public int majorityElement(int[] nums) 
    {
        HashMap<Integer ,  Integer> mapp=new HashMap<>();
        int freq=0;
        int majoelement=0;
        for(int i=0;i<nums.length;i++)
        {
            mapp.put(nums[i] , mapp.getOrDefault(nums[i] , 0) +1);
        }    

        for(Map.Entry<Integer ,  Integer > entry : mapp.entrySet())
        {
            if(entry.getValue() > freq)
            {
                freq=entry.getValue();
                majoelement=entry.getKey();
            }
        }

        return majoelement;


    }
}