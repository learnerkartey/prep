class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n]; 
        for (int i=0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1]; 
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0; 
        int endPointer = 0; 
        int usedRoom = 0;
        while (startPointer < n) {
            if (start[startPointer] >= end[endPointer]) {
                // Have to allocate new room
                // No meeting has endd by the time meeting is to start
                usedRoom--;
                endPointer++;
            }
            usedRoom++; 
            startPointer++; 
        }
        return usedRoom;
    }

}
