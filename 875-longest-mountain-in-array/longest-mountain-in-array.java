class Solution {
    public int longestMountain(int[] arr) {
        int left=1;
        int right=1;
        int n=arr.length;

        if(n<3)
        {
            return 0;
        }

        int ans=0;
       
        for(int i=1;i<n-1;i++)
        {
            if(arr[i-1] < arr[i] && arr[i]  > arr[i+1])
            {
            left=i;
            right=i;

            while (left >0 && arr[left]>arr[left-1])
            {
                left--;
            }   
                while (right<n-1 && arr[right]>arr[right+1])
                {
                    right++;
                }
                int length=right-left+1;

                ans=Math.max(ans,length);
            }
        }
       return ans;
        }
        
        
    }
