package sudoku;

public class SudokuBoard {
    private int size;
    private SudokuCell[][] grid;
    public SudokuBoard(int[][] _grid) {
        size = (int)(Math.sqrt(_grid.length));
        grid = reconstructGrid(_grid);
    }

    public SudokuBoard(int _size, char _difficulty) {
        size = _size;
        // int z = size*size;
        grid = new SudokuCell[size*size][size*size];
        for (int i = 0; i < size*size; i++) {
            for (int j = 0; j < size*size; j++) {
                grid[i][j] = new SudokuCell((int)((Math.random()*8))+1, true);
                if (!checkIfValueIsOk(i, j)) {
                    // System.out.println(grid[i][j].value);
                    System.out.println(i + " " + j);
                    // return;
                    j--;
                } else {
                    System.out.println(grid[i][j].value);
                }
            }
        }
        switch(_difficulty) {
            case 'm':
                break;
            case 'h':
                break;
            default:
                break;
        }
    }

    public int getSize(){
        return size;
    }

    public SudokuCell getCell(int i, int j) {
        return grid[i][j];
    }

    private boolean isRowOk(int _value, int i) {
        boolean f = false;
        for (int u = 0; u < size*size; u++) {
            if (getCell(i,u) != null && getCell(i,u).getValue() == _value) {
                if (f) return false;
                f = true;
            }
        }
        return true;
    }

    private boolean isColumnOk(int _value, int j) {
        boolean f = false;
        for (int u = 0; u < size*size; u++) {
            if (getCell(u,j) != null && getCell(u,j).getValue() == _value) {
                if (f) return false;
                f = true;
            }
        }
        return true;
    }

    private boolean isBlockOk(int _value, int i, int j) {
        int lmod = 3*(int)(i/size);
        int wmod = 3*(int)(j/size);
        boolean f = false;
        for (int u = lmod; u < size+lmod; u++) {
            for (int v = wmod; v < size+wmod; v++) {
                if (getCell(u,v) != null && getCell(u,v).getValue() == _value) {
                    if (f) return false;
                    f = true;
                }
            }
        }
        return true;
    }

    public boolean checkIfValueIsOk(int i, int j) {
        if (!isRowOk(getCell(i, j).getValue(), i) || !isColumnOk(getCell(i, j).getValue(), j) || !isBlockOk(getCell(i, j).getValue(), i, j)) return false;
        return true;
    }

    public boolean checkIfIsSolved() {
        for (int i = 0; i < size*size; i++) {
            for (int j = 0; j < size*size; j++) {
                if (getCell(i, j).value == 0) return false;
                if (!checkIfValueIsOk(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private SudokuCell[][] reconstructGrid(int[][] _grid) {
        SudokuCell[][] newGrid = new SudokuCell[size*size][size*size];
        for (int i = 0; i < size*size; i++) {
            for (int j = 0; j < size*size; j++) {
                newGrid[i][j] = new SudokuCell(_grid[i][j], _grid[i][j] != 0 ? true : false);
            }
        }
        return newGrid;
    }

    public void print() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j].value);
                if (j != grid.length-1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            for (int j = 0; j < grid.length*3+6; j++) {
                if ((j-2)%4==0) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}