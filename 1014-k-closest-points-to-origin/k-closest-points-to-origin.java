class Pair
{
    int distance;
    int x;
    int y;

    Pair(int d, int x , int y)
    {
        this.distance=d;
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k)
    {
        int ans[][]=new int[k][2];

        if(points.length==0)
        {
            return ans;
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>
        ((a,b)  -> Integer.compare(b.distance , a.distance));


        for(int i=0;i<points.length;i++)
        {
            int dist=points[i][0]*points[i][0]
                     +points[i][1]*points[i][1];


                     if(pq.size()<k)
                     {
                        pq.offer(new Pair(dist , points[i][0], points[i][1]));
                     }
                     else
                     {
                        if(dist<pq.peek().distance)
                        {
                            pq.poll();


                            pq.offer(new Pair (dist , points[i][0] ,points[i][1]));
                        }
                     }
        }
        int index=0;

        while(!pq.isEmpty())
        {
            Pair p=pq.poll();

            ans[index][0]=p.x;
            ans[index][1]=p.y;

            index++;
        }

        return ans;
    }   
}

















































/* import java.util.*;

class Pair {
    int distance;
    int x;
    int y;

    Pair(int d, int x, int y) {
        this.distance = d;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] ans = new int[k][2];

        if (points.length == 0)
            return ans;

        // Max Heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.distance, a.distance)
        );

        for (int i = 0; i < points.length; i++) {

            int dist = points[i][0] * points[i][0]
                     + points[i][1] * points[i][1];

            if (pq.size() < k) {
                pq.offer(new Pair(
                    dist, points[i][0], points[i][1]
                ));
            } else {
                if (dist < pq.peek().distance) {
                    pq.poll();

                    pq.offer(new Pair(
                        dist, points[i][0], points[i][1]
                    ));
                }
            }
        }

        int index = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            ans[index][0] = p.x;
            ans[index][1] = p.y;

            index++;
        }

        return ans;
    }
}*/