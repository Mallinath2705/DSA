class Pair
{
    int freq;
    String word;

    Pair(int f , String w)
    {
        this.freq=f;
        this.word=w;
    }

    public String toString()
    {
        return "("+freq+","+word+")";
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) 
    {
      HashMap<String, Integer> map = new HashMap<>();

    for (String word : words) 
    {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<Pair> pq =new PriorityQueue<>(
        (a,b) -> 
        {
            if(a.freq!=b.freq)
            {
                return Integer.compare(a.freq ,b.freq);
            }
        return b.word.compareTo(a.word);        }
    );

    for (String word : map.keySet())
    {
        int freq=map.get(word); 
        
    if(pq.size()<k)
    {
        pq.offer(new Pair(freq , word));
    }
    else {
    Pair p = new Pair(freq, word);

    if (pq.comparator().compare(p, pq.peek()) > 0) {
        pq.poll();
        pq.offer(p);
    }
}

    }
        List<String>ans=new ArrayList<>();

        while(!pq.isEmpty())
        {
            Pair p=pq.poll();

            ans.add(p.word);
        }
        Collections.reverse(ans);
        return ans;
    }
}