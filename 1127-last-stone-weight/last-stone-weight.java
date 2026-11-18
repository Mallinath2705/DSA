class Pair
{
    int element;
    int posi;

    Pair(int e , int p)
    {
        this.element=e;
        this.posi=p;
    }
}
class Solution {
    public int lastStoneWeight(int[] stones) 
    {

        PriorityQueue<Pair> pq =new PriorityQueue<>(
            (a , b) ->
            {
                if(a.element!=b.element)
                {
                    return Integer.compare(b.element , a.element);
                }
                return Integer.compare(a.posi , b.posi);
            }
        );
        for(int i = 0; i < stones.length; i++)
            {
                 pq.offer(new Pair(stones[i], i));
            }
    while(pq.size()>1)
    {

    
        Pair y=pq.poll();
        Pair x=pq.poll();
            
            
            if(x.element<y.element)
            {
                y.element=y.element-x.element;
                pq.offer(y);
            }
            }
            if(pq.isEmpty())
            {
                return 0;
            }

            return pq.peek().element;
    }
}