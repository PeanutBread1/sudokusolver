public class Sudoku{        
    
    public boolean findEmptyCell(int[][] board, int[] cell) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    cell[0] = i;
                    cell[1] = j;
                    return true;
                }
            }
        }
        return false; //No empty cells found
    }
    
    
    public boolean checkRow(int[][] board, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == num) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkCol(int board[][], int col, int numbToInsert){//check if number we are inserting is in the same column
        for(int i = 0;i < 9; i++){
            if(board[i][col] == numbToInsert){
                return false;
            }
        }
        return true;
    }
    public int[][] markGrid(int row, int col){ //mark grid 3x3 grid 
        if(row  < 3){
            if(col < 3){
                int arr[][] = {{0,1,2},{0,1,2}};
                return arr;
            }else if(col < 6){
                int arr[][] = {{0,1,2},{3,4,5}};
                return arr;
            }
            else{
                int arr[][] = {{0,1,2},{6,7,8}};
                return arr;
            }
        }else if(row < 6){
            if(col < 3){
                int arr[][] = {{3,4,5},{0,1,2}};
                return arr;
            }else if(col < 6){
                int arr[][] = {{3,4,5},{3,4,5}};
                return arr;
            }
            else{
                int arr[][] = {{3,4,5},{6,7,8}};
                return arr;
            }
        }else{
            if(col < 3){
                int arr[][] = {{6,7,8},{0,1,2}};
                return arr;
            }else if(col < 6){
                int arr[][] = {{6,7,8},{3,4,5}};
                return arr;
            }
            else{
                int arr[][] = {{6,7,8},{6,7,8}};
                return arr;
            }

        }
    }
    public boolean check3x3(int[][] board, int row, int col, int num) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(int board[][], int row, int col, int numbToInsert){
        if(checkRow(board, row, numbToInsert ) && checkCol(board, col, numbToInsert) && check3x3(board, row, col, numbToInsert) == true){
            return true;
        }else{
            return false;
        }
    }
    public boolean sudokuRecursion(int[][] board) {
        int[] cell = new int[2]; 
        if (!findEmptyCell(board, cell)) {
            return true; 
        }
    
        int row = cell[0], col = cell[1];
    
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                
                if (sudokuRecursion(board)) {
                    return true; 
                }
    
                board[row][col] = 0; 
            }
        }
        return false; 
    }
    
}
