class Sudoku {

    public static boolean sudokuSolver(int sudoku[][],int row,int col) {
        //base case
        if (row == 9) {
            return true;
        }
        
        int newRow = row, newCol = col + 1;
        if (col + 1 == 9) {
            newCol = 0;
            newRow = row + 1;
        }
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, newRow, newCol);
        }
        //recursion
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, newRow, newCol)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isSafe(int sudoku[][],int row,int col,int digit) {
        //column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        //row
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        //grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        //3*3 grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return true;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
    }
}