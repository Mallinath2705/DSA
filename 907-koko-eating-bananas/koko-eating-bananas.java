class Solution 
{
    int hourCountHelper(int [] arr , int n , int speed )
    {
        int hours=0;
        for(int i=0;i<n;i++)
        {
            hours=hours+arr[i]/speed;
            if(arr[i]%speed!=0)
            {
                hours++;
            }
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) //piles mhnje kelli che gatte 
    {
        int n=piles.length;
        int low=1;  
        int high=0;
        for(int i=0;i<n;i++)
        {
            high=Math.max(high,piles[i]);
        }



        while(low<high)
        {
            int guess=low+(high-low)/2;
            int hours= hourCountHelper(piles , n ,guess );
            if(hours>h)
            {
                low=guess+1;
            }
            else
            {   
                high=guess;
            }
        }
      return  low;
    }
}