package com.kazarmax;

import java.util.Scanner;

public class Field {

    public static final int DEFAULT_FIELD_SIZE = 3;
    private static final char DEFAULT_FIELD_VALUE = ' ';
    private final int fieldSize;
    private final char[][] field;
    private int fieldCellIndexI = -1;
    private int fieldCellIndexJ = -1;

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldCellIndexI(int fieldCellIndexI) {
        if (hasCorrectCellCoordinateValue(fieldCellIndexI)) {
        this.fieldCellIndexI = fieldCellIndexI;
        } else {
            System.out.println("Некорректное значение координаты");
        }
    }

    public void setFieldCellIndexJ(int fieldCellIndexJ) {
        if (hasCorrectCellCoordinateValue(fieldCellIndexJ)) {
            this.fieldCellIndexJ = fieldCellIndexJ;
        } else {
            System.out.println("Некорректное значение координаты");
        }
    }

    public boolean isWin(char playerCellValue) {
        return checkMainDiag(playerCellValue) || checkSubDiag(playerCellValue) || checkLines(playerCellValue);
    }

    private boolean checkMainDiag(char playerCellValue) {
        int cellCount = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[i][i] == playerCellValue) {
                cellCount++;
            }
        }
        return cellCount == fieldSize;
    }

    private boolean checkSubDiag(char playerCellValue) {
        int cellCount = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[i][fieldSize - i - 1] == playerCellValue) {
                cellCount++;
            }
        }
        return cellCount == fieldSize;
    }

    public boolean checkLines(char playerCellValue) {
        boolean checkLines = false;
        for (int i = 0; i < fieldSize; i++) {
            if (checkHorLine(i, playerCellValue) || checkVertLine(i, playerCellValue)) {
                checkLines = true;
                break;
            }
        }
        return checkLines;
    }

    public boolean checkVertLine(int lineNumber, char playerCellValue) {
        int cellCount = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[i][lineNumber] == playerCellValue) {
                cellCount++;
            }
        }
        return cellCount == fieldSize;
    }

    public boolean checkHorLine(int lineNumber, char playerCellValue) {
        int cellCount = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[lineNumber][i] == playerCellValue) {
                cellCount++;
            }
        }
        return cellCount == fieldSize;
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
            field[lineNumber][i] = DEFAULT_FIELD_VALUE;
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
            showCell(lineNumber, i);
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
        System.out.println("**************************************************");
        System.out.println("Введите координаты ячейки, " + playerName);
        System.out.println("Номер строки:");
        fieldCellIndexI = getFieldCellIndex();
        System.out.println("Номер столбца:");
        fieldCellIndexJ = getFieldCellIndex();
        if (hasCorrectCellCoordinateValue(fieldCellIndexI) && hasCorrectCellCoordinateValue(fieldCellIndexJ) && isCellEmpty(fieldCellIndexI, fieldCellIndexJ)) {
            System.out.println("Вы указали ячейку с координатами: [" + fieldCellIndexI + ", " + fieldCellIndexJ + "]");
        } else {
            System.out.println("Неверные координаты");
            getFieldCellCoordinates(playerName);
        }
    }

    public void setFieldCell(char playerCellValue) {
        field[fieldCellIndexI][fieldCellIndexJ] = playerCellValue;
        System.out.println("Результат хода:");
        showFields();
    }

    private boolean hasCorrectCellCoordinateValue(int i) {
        return (i >= 0) && (i < fieldSize);
    }

    public boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == DEFAULT_FIELD_VALUE) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    public boolean isCellEmpty(int coordinateI, int coordinateJ) {
        return field[coordinateI][coordinateJ] == DEFAULT_FIELD_VALUE;
    }





}
