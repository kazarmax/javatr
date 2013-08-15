package com.kazarmax;

import java.util.Scanner;

public class Field {

    public static final int DEFAULT_FIELD_SIZE = 3;
    private static final char DEFAULT_FIELD_VALUE = ' ';
    private final int fieldSize;
    private final char[][] field;
    public int fieldCellIndexI = -1;
    public int fieldCellIndexJ = -1;

    public boolean isWin(char playerCellValue) {
        return checkMainDiag(playerCellValue) || checkSubDiag(playerCellValue) || checkLines(playerCellValue);
    }

    private boolean checkMainDiag(char playerCellValue) {
        boolean checkMainDiag = false;

        search:
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][i] != playerCellValue) {
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

    private boolean checkSubDiag(char playerCellValue) {
        boolean checkSubDiag = false;

        search:
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][3 - i -1] != playerCellValue) {
                    checkSubDiag = false;
                    break search;
                } else {
                    checkSubDiag = true;
                    break;
                }
            }
        }
        return checkSubDiag;
    }

    public boolean checkLines(char playerCellValue) {
        boolean checkLines = false;

        for (int i = 0; i < fieldSize; i++) {
            if (checkHorLine(i, playerCellValue) || checkVertLine(i, playerCellValue)) {
                checkLines = true;
                break;
            } else {
                continue;
            }
        }
        return checkLines;
    }

    public boolean checkVertLine(int lineNumber, char playerCellValue) {
        boolean checkVertLine = false;

        for (int i = 0; i < fieldSize; i++) {
            if (field[i][lineNumber] != playerCellValue) {
                checkVertLine = false;
                break;
            } else {
                checkVertLine = true;
            }
        }
        return checkVertLine;
    }

    public boolean checkHorLine(int lineNumber, char playerCellValue) {
        boolean checkHorLine = false;

        for (int i = 0; i < fieldSize; i++) {
            if (field[lineNumber][i] != playerCellValue) {
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

        if (hasCorrectCellCoordinates(fieldCellIndexI) && hasCorrectCellCoordinates(fieldCellIndexJ) && !cellIsBusy(fieldCellIndexJ, fieldCellIndexI)) {
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

    private boolean hasCorrectCellCoordinates(int i) {
        if (i >= 0 && i < fieldSize) {
            return true;
        } else {
            return false;
        }
    }

    private boolean cellIsBusy(int cellIndexI, int cellIndexJ) {
        return field[cellIndexI][cellIndexJ] != DEFAULT_FIELD_VALUE;
    }

    public boolean isFull() {

        boolean isFull = true;

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == DEFAULT_FIELD_VALUE) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }


}
