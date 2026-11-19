
class Pair {
    int freq;
    char element;

    Pair(int f, char c) {
        this.freq = f;
        this.element = c;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> mapp = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            char ch = tasks[i];
            mapp.put(ch, mapp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq != b.freq) {
                    return Integer.compare(b.freq, a.freq);
                }
                return Character.compare(a.element, b.element);
            }
        );

        for (char ch : mapp.keySet()) {
            pq.offer(new Pair(mapp.get(ch), ch));
        }

        int result = 0;

        while (!pq.isEmpty()) {

            ArrayList<Pair> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {

                Pair p = pq.poll();

                if (p.freq > 1) {
                    p.freq--;
                    temp.add(p);
                }

                result++;
                cycle--;
            }

            for (Pair p : temp) {
                pq.offer(p);
            }

            if (!pq.isEmpty()) {
                result += cycle;
            }
        }

        return result;
    }
}
