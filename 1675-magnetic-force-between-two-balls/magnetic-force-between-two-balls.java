class Solution {
    boolean canWeFit(int []position , int m , int guesseddist , int n)
    {
        int magnet=1;
        int prevmagnet=position[0];

        for(int i=1;i<n;i++)
        {
            int dist=position[i]-prevmagnet;
            if( dist >=guesseddist)
            {
                magnet++;
                prevmagnet=position[i];
            }
            if(magnet >= m)
            {
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) 
    {
        Arrays.sort(position);
        int n=position.length;
        int low=0;
        int high=position[n-1]-position[0];
        int ans=0;

        while(low<=high)
        {
            int guesseddist=low+(high-low)/2;
            if(canWeFit(position , m ,guesseddist , n))
            {
                ans=guesseddist;
                low=guesseddist+1;
            }
            else
            {
                high=guesseddist-1;
            }
        }
        return ans;
    }
}