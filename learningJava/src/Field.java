
public class Field {

    private static final int FIELD_SIZE = 3;

    private static final char DEFAULT_FIELD_VALUE = ' ';

    private char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

    public void eraseField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            eraseLine(i);
        }
    }

    private void eraseLine(int lineNumber) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[i][lineNumber] = DEFAULT_FIELD_VALUE;
        }
    }


    public void showFields() {
        System.out.println();

        for (int i = 0; i < FIELD_SIZE; i++) {
            showLine(i);
            System.out.println();
        }
        System.out.println();
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            showCell(i, lineNumber);
        }
    }

    private void showCell(int i, int i2) {
        System.out.print("[" + field[i][i2] + "]");
    }




}
