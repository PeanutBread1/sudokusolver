public class Sudoku{        
    
    public boolean checkBoardEmpty(int board[][], int row, int col){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[row][col] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkCellEmpty(int board[][],int row, int col){
        if(board[row][col] == 0){
            return false;
        }
        return true;
    }
    public boolean checkRow(int board[][], int row, int numbToInsert){ //check if number we are inserting is in the same row
        for(int i = 0;i < 9; i++){
            if(board[row][i] == numbToInsert){
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
    public boolean check3x3(int board[][], int row, int col, int numbToInsert){//check if number we are inserting is in the same 3x3 grid
        int grid[][] = markGrid(row, col); //if row = 3, col = 3 grid[][] = {{3,4,5},{3,4,5}}

        for(int i = grid[0][0]; i < i+3; i++){
            for(int j = grid[1][0]; j < j + 3; j++){
                if(board[i][j] == numbToInsert){
                    return false; //numb in 3x3
                }
            }

        }
        return true; //numb not in 3x3

    }
    public boolean isValid(int board[][], int row, int col, int numbToInsert){
        if(checkRow(board, row, numbToInsert ) && checkCol(board, col, numbToInsert) && check3x3(board, row, col, numbToInsert) == true){
            return true;
        }else{
            return false;
        }
    }
    public boolean sudokuRecursion(int board[][], int row, int col){
        row = 0;
        col = 0;
        if(checkBoardEmpty(board, row, col)){ //if board is full return true
            return true;
        }else{
            for(int numbToInsert = 0; numbToInsert < 9; numbToInsert++){//loop through numbers to insert
                if(checkCellEmpty(board, row, col)&& isValid(board, row, col, numbToInsert)){//check current cell if its empty. if it is and the number we are inserting is valid, insert.
                    board[row][col] = numbToInsert; //if empty and valid number, insert first valid number
                    sudokuRecursion(board, row, col);
                }else if(checkCellEmpty(board, row, col) && isValid(board, row, col, numbToInsert) != true){
                    if(col == 9){
                        sudokuRecursion(board, row + 1, 1);

                    }
                    else{
                        sudokuRecursion(board, row, col+1);
                    }
                }
                else {
                    board[row][col] = 0;
                    return false;
                }
            }
        }
        return false;
    }
}