class SurroundedRegions {
     public void solve(char[][] board) {
        if (board.length == 0) return;
        
        int rowN = board.length;
        int colN = board[0].length;
        Queue<Point> queue = new LinkedList<Point>();
       
       //get all 'O's on the edge first
        for (int r = 0; r< rowN; r++){
        	if (board[r][0] == 'O') {
        		board[r][0] = '+';
                queue.add(new Point(r, 0));
        	}
        	if (board[r][colN-1] == 'O') {
        		board[r][colN-1] = '+';
                queue.add(new Point(r, colN-1));
        	}
        	}
        
        for (int c = 0; c< colN; c++){
        	if (board[0][c] == 'O') {
        		board[0][c] = '+';
                queue.add(new Point(0, c));
        	}
        	if (board[rowN-1][c] == 'O') {
        		board[rowN-1][c] = '+';
                queue.add(new Point(rowN-1, c));
        	}
        	}
        

        //BFS for the 'O's, and mark it as '+'
        while (!queue.isEmpty()){
        	Point p = queue.poll();
        	int row = p.x;
        	int col = p.y;
        	if (row - 1 >= 0 && board[row-1][col] == 'O') {board[row-1][col] = '+'; queue.add(new Point(row-1, col));}
        	if (row + 1 < rowN && board[row+1][col] == 'O') {board[row+1][col] = '+'; queue.add(new Point(row+1, col));}
        	if (col - 1 >= 0 && board[row][col - 1] == 'O') {board[row][col-1] = '+'; queue.add(new Point(row, col-1));}
            if (col + 1 < colN && board[row][col + 1] == 'O') {board[row][col+1] = '+'; queue.add(new Point(row, col+1));}        	      
        }
        

        //turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i<rowN; i++){
        	for (int j=0; j<colN; j++){
        		if (board[i][j] == 'O') board[i][j] = 'X';
        		if (board[i][j] == '+') board[i][j] = 'O';
        	}
        }
       
        
    }
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
