class Solution {
    public int subarraysDivByK(int[] nums, int k) 
    {
        int sum=0;
        int result=0;
        HashMap<Integer , Integer >remainderSave=new HashMap<>();
        remainderSave.put(0,1);

        for(int i : nums)
        {
            sum+=i ; // for each madhe nums[i] asa nahi lihaych fkt i lihaych 
            int remainder =sum%k;

            if(remainder < 0)
            {
                remainder+=k;
            }
            result+=remainderSave.getOrDefault(remainder , 0); // remainder kiti vela ala ahe te value fetch krt and result madhe add krt 
            remainderSave.put(remainder , remainderSave.getOrDefault(remainder , 0)+1);// rem kiti vela ala ahe and nasel tr add and already asel tr ++
        }    
        return result;
    }
}