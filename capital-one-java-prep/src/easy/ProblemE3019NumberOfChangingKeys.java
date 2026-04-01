class Solution {
    public int countKeyChanges(String s) {
        if(s == null || s.trim().length() == 0) {
            return 0;
        }
        int chatChangeCount = 0;
        char[] arr = s.toLowerCase().toCharArray();
        for(int i =0 ;i < arr.length -1 ; i++) {
            if(arr[i] != arr[i+1]) {
                chatChangeCount++;
            }
        }
        return chatChangeCount;
    }
}
