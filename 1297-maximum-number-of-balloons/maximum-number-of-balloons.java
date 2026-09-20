class Solution {
    public int maxNumberOfBalloons(String text)
    {
        int [] freqq=new int[26];
        int n=text.length();

        for(int i=0;i<n;i++)
        {
            
            freqq[text.charAt(i)-'a']++;
        }
        int ans=freqq['b'-'a'];

        ans=Math.min(ans,freqq['a'-'a']);
        ans=Math.min(ans,freqq['l'-'a']/2);
        ans=Math.min(ans,freqq['o'-'a']/2);
        ans=Math.min(ans,freqq['n'-'a']);

        return ans;
    }
}