package sudoku;

public class SudokuCell {
    int value;
    boolean fixed;
    public SudokuCell(int _value, boolean _fixed) {
        value = _value;
        fixed = _fixed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int _value) {
        value = _value;
    }

    public boolean getFixed() {
        return fixed;
    }

    public void setFixed(boolean _fixed) {
        fixed = _fixed;
    }
}

