class Pair
{
    int count;
    int index;

    Pair(int count , int index)
    {
        this.count=count;
        this.index=index;
    }
}
class Solution {

    public int  countOnes(int []row)
    {
        int count=0;

        for(int val :row)
        {
            if(val==1)
            {
                count++;
            }
        }
        return count;
    }
    public int[] kWeakestRows(int[][] mat, int k) 
    {
         PriorityQueue<Pair>pq=new PriorityQueue<>(
            (a,b) -> 
            {
                if(a.count != b.count)
                {
                    return Integer.compare(b.count,a.count);
                }
                return Integer.compare(b.index , a.index);
            }
         );

         for(int i=0;i<mat.length;i++)
         {
            int count=countOnes(mat[i]);
            Pair p = new Pair(count , i );


            if(pq.size()<k)
            {
                pq.offer(p); //pair ch p ahe he mhnje pair ch add kel 
            }
            else
            {
                Pair top=pq.peek();
                if(count <top.count || (count==top.count && i<top.index))
                {
                    pq.poll();
                    pq.offer(p);
                }
            }
         }
        int []ans=new int[k];
         for(int i=k-1;i>=0;i--)
         {
            ans[i]=pq.poll().index;  
         }
        return ans;
    }
}