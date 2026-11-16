class Pair
{
    int distance;
    int element;

    Pair(int d , int e)
    {
        this.distance=d;
        this.element=e;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> 
            {
            if(a.distance!=b.distance)
            {
                return Integer.compare(b.distance,a.distance);
            }
            return Integer.compare(b.element, a.element);
            
            });

            for(int i=0;i<arr.length;i++)
            {
                int dist=Math.abs(arr[i]-x);
                Pair p=new Pair(dist ,arr[i]);

                if(pq.size()<k)
                {
                    pq.offer(p);
                }
                else
                {
                    
                    Pair highdist=pq.peek();

                    if(highdist.distance>p.distance || p.distance==highdist.distance && p.element <highdist.element)
                    {
                        pq.poll();
                        pq.offer(p);
                    }
                }
            }

        List<Integer> ans=new ArrayList<>();
        for (int i = k - 1; i >= 0; i--) 
        {
        ans.add(pq.poll().element);
        }
        Collections.sort(ans);
        return ans;

    }
}