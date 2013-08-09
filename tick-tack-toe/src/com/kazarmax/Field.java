package com.kazarmax;

import java.util.Scanner;

public class Field {

//    public static char[][] exampleField = {{'x', 'o', 'o'},
//                                           {'x', 'o', 'o'},
//                                           {'x', 'o', 'o'}};

    public static final int DEFAULT_FIELD_SIZE = 3;

    private final int fieldSize;

    private static final char DEFAULT_FIELD_VALUE = ' ';

    private final char[][] field;

    public int fieldCellIndexI = -1;
    public int fieldCellIndexJ = -1;

    public boolean isWin() {
        return checkMainDiag() || checkSubDiag() || checkLines();
    }

    private boolean checkMainDiag() {
        boolean checkMainDiag = false;

        search:
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][i] != 'x') {
                    checkMainDiag = false;
                    break search;
                } else {
                    checkMainDiag = true;
                    break;
                }
            }
        }
        return checkMainDiag;

    }

    private boolean checkSubDiag() {
        boolean checkSubDiag = false;

        search:
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][3 - i -1] != 'x') {
                    checkSubDiag = false;
                    break search;
                } else {
                    checkSubDiag = true;
                    break;
                }
            }
        }
        //System.out.println("checkSubDiag = " + checkSubDiag);
        return checkSubDiag;
    }

    public boolean checkLines() {
        boolean checkLines = false;

        for (int i = 0; i < fieldSize; i++) {
            if (checkHorLine(i) || checkVertLine(i)) {
                checkLines = true;
                break;
            } else {
                continue;
            }
        }
        return checkLines;
    }

    public boolean checkVertLine(int lineNumber) {
        boolean checkVertLine = false;

        for (int i = 0; i < fieldSize; i++) {
            if (field[i][lineNumber] != 'x') {
                checkVertLine = false;
                break;
            } else {
                checkVertLine = true;
            }
        }
        return checkVertLine;
    }

    public boolean checkHorLine(int lineNumber) {
        boolean checkHorLine = false;

        for (int i = 0; i < fieldSize; i++) {
            if (field[lineNumber][i] != 'x') {
                checkHorLine = false;
                break;
            } else {
                checkHorLine = true;
            }
        }
        return checkHorLine;
    }



    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size){
        fieldSize = size;
        field = new char[fieldSize][fieldSize];
    }

    public void eraseField() {
        for (int i = 0; i < fieldSize; i++) {
            eraseLine(i);
        }
    }

    private void eraseLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            field[i][lineNumber] = DEFAULT_FIELD_VALUE;
        }
    }


    public void showFields() {
        System.out.println();

        for (int i = 0; i < fieldSize; i++) {
            showLine(i);
            System.out.println();
        }
        System.out.println();
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            showCell(i, lineNumber);
        }
    }

    private void showCell(int i, int i2) {
        System.out.print("[" + field[i][i2] + "]");
    }

    private int getFieldCellIndex() {

        int fieldCellIndex;

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            fieldCellIndex = sc.nextInt();
            return fieldCellIndex;
        } else {
            return -1;
        }
    }

    public void getFieldCellCoordinates(String playerName) {

        System.out.println("Введите координаты ячейки, " + playerName);
        System.out.println("Номер строки:");
        fieldCellIndexI = getFieldCellIndex();
        System.out.println("Номер столбца:");
        fieldCellIndexJ = getFieldCellIndex();

        if (checkIfCorrectCellCoordinates(fieldCellIndexI) && checkIfCorrectCellCoordinates(fieldCellIndexJ)) {
            System.out.println("Вы указали ячейку с координатами: [" + fieldCellIndexI + ", " + fieldCellIndexJ + "]");
        } else {
            System.out.println("Неверные координаты");
            getFieldCellCoordinates(playerName);
        }
    }

    public void setFieldCell(char playerCellValue) {
        field[fieldCellIndexJ][fieldCellIndexI] = playerCellValue;

        showFields();

    }

    public void manSetFieldCell(int cellCoordI, int cellCoordJ, char playerCellValue) {
        field[cellCoordI][cellCoordJ] = playerCellValue;

        showFields();
    }

    private boolean checkIfCorrectCellCoordinates(int i) {
        if (i >= 0 && i < fieldSize) {
            return true;
        } else {
            return false;
        }
    }

    public boolean FieldNotFull() {

        boolean FieldNotFull = false;

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == DEFAULT_FIELD_VALUE) {
                    FieldNotFull = true;
                }
            }
        }
        return FieldNotFull;
    }


}
