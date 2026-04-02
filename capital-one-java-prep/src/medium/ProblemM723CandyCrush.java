class Solution {
    public int[][] candyCrush(int[][] board) {
        if(board.length == 0) return board;        
        int crushed = crush(board);
        while(crushed > 0){
            dropUncrushed(board);
            crushed = crush(board);
        }        
        return board;
    }    
    private int crush(int[][] board){
        Set<int[]> set = new HashSet<>();        
        for(int i=0; i < board.length; i++){
            for(int j=2; j < board[0].length; j++){
                if(board[i][j-2] == board[i][j-1] && board[i][j-1] == board[i][j] && board[i][j] != 0){
                    set.addAll(Set.of(new int[]{i, j-2}, new int[]{i, j-1}, new int[]{i, j}));
                }
            }
        }        
        for(int j=0; j < board[0].length; j++){
            for(int i=2; i < board.length; i++){
                if(board[i-2][j] == board[i-1][j] && board[i-1][j] == board[i][j] && board[i][j] != 0){
                    set.addAll(Set.of(new int[]{i-2, j}, new int[]{i-1, j}, new int[]{i, j}));
                }
            }
        }        
        for(int[] p: set){
            board[p[0]][p[1]] = 0;
        }        
        return set.size();
    }    
    private void dropUncrushed(int[][] board){
        for(int j=0; j < board[0].length; j++){
            
            int offset = 0;
            for(int i=board.length-1; i >= 0; i--){
                if(board[i][j] == 0){
                    offset++;
                }else{
                    board[i+offset][j] = board[i][j];
                    board[i][j] = (offset > 0) ? 0 : board[i][j];
                }
            }
        }
    }
}
