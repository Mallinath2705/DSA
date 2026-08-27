class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // snapshots[i] = counts remaining after matching target[0..i-1]
        int[][] snapshots = new int[n][];
        int[] cur = cnt.clone();
        int m = 0;
        for (int i = 0; i < n; i++) {
            snapshots[i] = cur.clone();
            int idx = target.charAt(i) - 'a';
            if (cur[idx] > 0) {
                cur[idx]--;
                m = i + 1;
            } else {
                break;
            }
        }

        int startI = Math.min(m, n - 1);

        for (int i = startI; i >= 0; i--) {
            int[] countsI = snapshots[i];
            int t = target.charAt(i) - 'a';
            int chosen = -1;
            for (int c = t + 1; c < 26; c++) {
                if (countsI[c] > 0) {
                    chosen = c;
                    break;
                }
            }
            if (chosen != -1) {
                int[] remaining = countsI.clone();
                remaining[chosen]--;
                StringBuilder result = new StringBuilder();
                result.append(target, 0, i);
                result.append((char) (chosen + 'a'));
                for (int c = 0; c < 26; c++) {
                    for (int k = 0; k < remaining[c]; k++) {
                        result.append((char) (c + 'a'));
                    }
                }
                return result.toString();
            }
        }

        return "";
    }
}
