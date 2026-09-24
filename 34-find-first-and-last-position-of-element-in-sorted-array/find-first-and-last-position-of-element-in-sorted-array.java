class Solution {
    public int[] searchRange(int[] nums, int target)
    {
     int n=nums.length;
     int start=-1;
     int end=-1;
     int low=0;
     int high=n-1;
     if(n==0)
     {
        return new int[]{start,end};
     }
     while(low<=high)
     {
        int  guess=low+(high-low)/2;
        if(nums[guess]==target)
        {
            start=guess;
            high=guess-1;  // Target सापडला, पण कदाचित त्याच्या left side ला अजून target असेल. त्यामुळे high कमी करून left side मध्ये पुन्हा binary search कर.

        }
        else if(nums[guess]<target)
        {
            low=guess+1;
        }
        else
        {
            high=guess-1;
        }

     }
        low=0;
        high=n-1;
     while(low<=high)
     {
int  guess=low+(high-low)/2;
        if(nums[guess]==target)
        {
            end=guess;
            low=guess+1;  // Target सापडला, पण कदाचित त्याच्या right side ला अजून target असेल. त्यामुळे high कमी करून right side मध्ये पुन्हा binary search कर.

        }
        else if(nums[guess]<target)
        {
            low=guess+1;
        }
        else
        {
            high=guess-1;
        }     }
     return new int[]{start, end};

    }
}