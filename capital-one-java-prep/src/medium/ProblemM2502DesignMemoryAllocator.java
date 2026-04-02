class Allocator {
    
    private final int[] memory;

    public Allocator(int n) {
        memory = new int[n];
        for(int i=0;i<memory.length; i++) {
            memory[i]= 0;
        }
    }
    
    public int allocate(int size, int mID) {
        int count =0;
        for(int i=0; i<memory.length; i++) {
            if(memory[i] == 0) {
                count++;
            } else {
                count = 0;
            }

            if(count >= size) {
                int startIndex = i - size+1;
                for(int j=startIndex; j<= i; j++) {
                    memory[j] = mID;
                }
                return startIndex;
            }            
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        int freed = 0;
        for(int i=0; i<memory.length; i++) {
            if(memory[i] == mID) {
                memory[i] = 0;
                freed++;
            }            
        }
        return freed;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
