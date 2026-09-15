class Solution {
    public String removeDuplicates(String s, int k) 
    {
        int n=s.length();
        Stack<int []>stackk=new Stack<>();// char and int both pair madhe store hoar stack madhe just like (a,2),(c,4) asa 
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);

            if(stackk.isEmpty())
            {
                stackk.push(new int []{c,1});   // stack madhe pair madhe data insert kela ahe apan 
                continue;
            }
            if(stackk.peek()[0]  !=c)
            {
                stackk.push(new int[]{c,1});
                continue;
            }
            int [] p=stackk.pop();
            p[1]++;

            if(p[1]==k)
            {
                continue;
            }
            stackk.push(p);
        }
        StringBuilder res=new StringBuilder();
        while(!stackk.isEmpty())
        {
                int []p=stackk.pop();

                while(p[1]-->0)
                {
                    res.append((char)p[0]);
                }
        }
        return res.reverse().toString();
    }
}