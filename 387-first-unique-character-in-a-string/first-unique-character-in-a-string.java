class Solution {
    public int firstUniqChar(String s) 
    {
        int n=s.length();
        int index=-1;
        HashMap<Character , Integer > mapp=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(mapp.containsKey(ch))
            {
                mapp.put(ch,mapp.get(ch)+1);
            }
            else
            {
                mapp.put(ch,1);
            }
        }   
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(mapp.get(ch)==1)
            {
                index=i;
                return i;
            }
        } 
        return index;
    }
}