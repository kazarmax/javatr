package com.kazarmax;

public class Computer {

    public final String name = "Computer";
    public static final char OWN_CELL_VALUE = 'o';
    public static final char ENEMY_CELL_VALUE = 'x';
    private static int bufferCellCoordinateI = -1;
    private static int bufferCellCoordinateJ = -1;
    private static boolean computerActionRequired = true;

    Field field;


    private void fillEmptyCell() {
        search:
        for (int i = 0; i < field.getFieldSize(); i++) {
            for (int j = 0; j < field.getFieldSize(); j++) {
                if (field.isCellEmpty(i, j)) {
                    setFieldCellCoordinates(i, j);
                    fillFieldCell();
                    break search;
                }
            }
        }
    }

    private void setFieldCellCoordinates(int i, int j) {
        field.setFieldCellIndexI(i);
        field.setFieldCellIndexJ(j);
    }

    private void fillFieldCell() {
        field.setFieldCell(OWN_CELL_VALUE);
    }

    public boolean isWinner() {
        return field.isWin(OWN_CELL_VALUE);
    }

    private void computerAction(char playerCellValue) {
        computerActionRequired = true;

        if (checkMainDiag(playerCellValue)) {
            setFieldCellCoordinates(bufferCellCoordinateI, bufferCellCoordinateJ);
            fillFieldCell();
            computerActionRequired = false;
        }
        else if (checkSubDiag(playerCellValue)) {
            setFieldCellCoordinates(bufferCellCoordinateI, bufferCellCoordinateJ);
            fillFieldCell();
            computerActionRequired = false;
        }
        else if (checkHorLine(playerCellValue)) {
            setFieldCellCoordinates(bufferCellCoordinateI, bufferCellCoordinateJ);
            fillFieldCell();
            computerActionRequired = false;
        }
        else if (checkVertLine(playerCellValue)) {
            setFieldCellCoordinates(bufferCellCoordinateI, bufferCellCoordinateJ);
            fillFieldCell();
            computerActionRequired = false;
        }
    }

    public void makeMove() {
        System.out.println("**************************************************");
        System.out.println("Ход компьютера ...");

        computerAction(OWN_CELL_VALUE);
        if (computerActionRequired) {
            computerAction(ENEMY_CELL_VALUE);
        }
        if (computerActionRequired) {
            fillEmptyCell();
        }
    }

    private boolean checkHorLine(char playerCellValue) {
        boolean checkHorLine = false;
        int cellCount = 0;
        search:
        for (int i = 0; i < field.getFieldSize(); i++) {
            cellCount = 0;
            for (int j = 0; j < field.getFieldSize(); j++) {
                if (field.getFieldCellValue(i,j) == playerCellValue) {
                    cellCount++;
                }
            }
            if (cellCount == field.getFieldSize() - 1 && hasHorEmptyCell(i)) {
                checkHorLine = true;
                bufferCellCoordinateI = i;
                break search;
            }
        }
        return checkHorLine;
    }

    private boolean hasHorEmptyCell(int lineNumber) {
        boolean hasHorEmptyCell = false;
        for (int j = 0; j < field.getFieldSize(); j++) {
            if (field.getFieldCellValue(lineNumber, j) == ' ') {
                hasHorEmptyCell = true;
                bufferCellCoordinateJ = j;
            }
        }
        return hasHorEmptyCell;
    }

    private boolean checkVertLine(char playerCellValue) {
        boolean checkVertLine = false;
        int cellCount = 0;
        search:
        for (int j = 0; j < field.getFieldSize(); j++) {
            cellCount = 0;
            for (int i = 0; i < field.getFieldSize(); i++) {
                if (field.getFieldCellValue(i,j) == playerCellValue) {
                    cellCount++;
                }
            }
            if (cellCount == field.getFieldSize() - 1 && hasVertEmptyCell(j)) {
                checkVertLine = true;
                bufferCellCoordinateJ = j;
                break search;
            }
        }
        return checkVertLine;
    }

    private boolean hasVertEmptyCell(int lineNumber) {
        boolean hasVertEmptyCell = false;
        for (int i = 0; i < field.getFieldSize(); i++) {
            if (field.getFieldCellValue(i, lineNumber) == ' ') {
                hasVertEmptyCell = true;
                bufferCellCoordinateI = i;
            }
        }
        return hasVertEmptyCell;
    }

    private boolean checkMainDiag(char playerCellValue) {
        boolean checkMainDiag = false;
        int cellCount = 0;
            for (int i = 0; i < field.getFieldSize(); i++) {
                if (field.getFieldCellValue(i, i) == playerCellValue) {
                    cellCount++;
                }
            }
            if (cellCount == field.getFieldSize() - 1 && hasMainDiagEmptyCell()) {
                checkMainDiag = true;
            }
        return checkMainDiag;
    }

    private boolean hasMainDiagEmptyCell() {
        boolean hasMainDiagEmptyCell = false;
        for (int i = 0; i < field.getFieldSize(); i++) {
                if (field.getFieldCellValue(i, i) == ' ') {
                    hasMainDiagEmptyCell = true;
                    bufferCellCoordinateI = i;
                    bufferCellCoordinateJ = i;
                }
        }
        return hasMainDiagEmptyCell;
    }

    private boolean checkSubDiag(char playerCellValue) {
        boolean checkSubDiag = false;
        int cellCount = 0;
        for (int i = 0; i < field.getFieldSize(); i++) {
            if (field.getFieldCellValue(i, field.getFieldSize() - i -1) == playerCellValue) {
                cellCount++;
            }
        }
        if (cellCount == field.getFieldSize() - 1 && hasSubDiagEmptyCell()) {
            checkSubDiag = true;
        }
        return checkSubDiag;
    }

    private boolean hasSubDiagEmptyCell() {
        boolean hasSubDiagEmptyCell = false;
        for (int i = 0; i < field.getFieldSize(); i++) {
            if (field.getFieldCellValue(i, field.getFieldSize() - i -1) == ' ') {
                hasSubDiagEmptyCell = true;
                bufferCellCoordinateI = i;
                bufferCellCoordinateJ = field.getFieldSize() - i -1;
            }
        }
        return hasSubDiagEmptyCell;
    }

}
