class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] actualNums = nums;
        Arrays.sort(actualNums);
        int maxLength = 0;
        int count = 0;
        for(int i=0; i<nums.length -1 ; i++) {
            if(actualNums[i] + 1 == actualNums[i+1]) {                
                count++;
            } else if (actualNums[i] == actualNums[i+1]) {

            }
            else {
                if(count > maxLength) {
                    maxLength = count;
                }                
                count = 0;
            }
        }
        return count > maxLength ? count +1  : maxLength + 1;
    }
}
