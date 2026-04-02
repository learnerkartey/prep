class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long result = 1;
        long curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                curr++;
            } else {
                curr = 1;
            }
            result += curr;
        }
        return result;
    }
}
