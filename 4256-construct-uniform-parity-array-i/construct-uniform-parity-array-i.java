class Solution {
    public boolean uniformArray(int[] nums1) {
        // Proof (parity argument):
        // - "All even" is achievable unless exactly one odd element exists (countOdd == 1)
        // - "All odd" is achievable unless zero odd elements exist (countOdd == 0)
        // These two failure conditions are mutually exclusive, so one target always works.
        return true;
    }
}