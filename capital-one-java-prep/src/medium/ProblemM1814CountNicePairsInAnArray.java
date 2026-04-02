class Solution {
     public int countNicePairs(int[] nums) {
        int mod = 1_000_000_007;
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int num : nums) {
            int value = num - reverse(num);

            count = (count + map.getOrDefault(value, 0)) % mod;
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        return (int) count;
    }

    private int reverse(int num) {
        int rev = 0;

        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }

        return rev;
    }
}
