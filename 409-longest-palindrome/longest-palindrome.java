class Solution {
    public int longestPalindrome(String s) 
    {
        int n=s.length();
        int [] freqq=new int[52];
        int count=0;
        boolean odd=false;

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z')
            {
                freqq[ch-'a']++;   //freqq[s.charAt(i)-'a'] pn chall ast but s.charAt(i) he ch ahe na so ch ch ghetl 
            }
            else{
            
            freqq[ch-'A'+26]++;
            }
            
        }

        for(int i=0;i<52;i++)
        {

            if(freqq[i]%2==0)
            {
                count+=freqq[i];
            }
            else if( freqq[i]%2==1)
            {
                count=count+freqq[i]-1;
                odd=true;
            }
        }
        if(odd)
        {
            count++;
        }
     return count;       
    }
}