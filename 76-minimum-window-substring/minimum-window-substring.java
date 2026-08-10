class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {

            char r = s.charAt(right);

            if (freq[r] > 0) {
                required--;
            }

            freq[r]--;
            right++;

            // Window contains all required characters
            while (required == 0) {

                // Check whether current window is smaller
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                // Remove left character
                char l = s.charAt(left);
                freq[l]++;

                if (freq[l] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}