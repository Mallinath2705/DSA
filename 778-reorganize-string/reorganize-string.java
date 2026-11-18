class Pair
{
    int frequency;
    char character;

    Pair(int f , char c)
    {
        this.frequency=f;
        this.character=c;
    }
}
class Solution {
    public String reorganizeString(String s) 
    {
        HashMap<Character , Integer > mapp=new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
         char ch=s.charAt(i);

        mapp.put(ch, mapp.getOrDefault(ch, 0) + 1);       
        }

    String res="";
    int seats=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>
        (
        (a, b) -> b.frequency - a.frequency
        );

        for(char ch : mapp.keySet())
        {
            pq.offer(new Pair (mapp.get(ch) , ch ));
        }


    while(pq.size()>1)
    {
        Pair p1 =pq.poll();
        Pair p2 =pq.poll();

        res +=p1.character;
        res +=p2.character;

        p1.frequency--;
        p2.frequency--;

        if(p1.frequency>0)
        {
            pq.offer(p1);
        }

        if(p2.frequency>0)
        {
            pq.offer(p2);
        }

    }
     if(!pq.isEmpty())
        {
            Pair last=pq.poll();

            if(last.frequency>1)
            {
                return "";
            }
            res += last.character;
        }

return res;

    }
}