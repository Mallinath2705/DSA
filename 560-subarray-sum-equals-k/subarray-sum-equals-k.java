class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        HashMap<Integer ,Integer>mapp=new HashMap<>();

        mapp.put(0,1);     //0 ch prefixx sum he 0 ch ast so 0 add kel
        int prefixsum=0;
        int count=0;

        for(int num : nums)
        {
            prefixsum+=num;

            int required=prefixsum-k;

            count+=mapp.getOrDefault(required , 0); //याचा अर्थ : Map मध्ये key असेल तर त्याची value दे, नाहीतर defaultValue दे.

            mapp.put(prefixsum , mapp.getOrDefault(prefixsum , 0)+1);
        }    
        return count;
    }
}