package sudoku;

public class SudokuSolver {
    public static boolean solveSudoku(SudokuBoard board, int i, int j) {
        int size = board.getSize();
        if (board.checkIfIsSolved() || (i == size*size-1 && j == size*size)) return true;
        if (j == size*size) {
            j = 0;
            i++;
        }
        if (board.getCell(i, j).getValue() != 0) return solveSudoku(board, i, j+1);
        for (int k = 0; k < size*size; k++) {
            board.getCell(i, j).setValue(k+1);
            if (board.checkIfValueIsOk(i,j)) {
                if (solveSudoku(board, i, j+1)) return true;
            } 
            board.getCell(i, j).setValue(0);
        }
        return false;
    }
}
