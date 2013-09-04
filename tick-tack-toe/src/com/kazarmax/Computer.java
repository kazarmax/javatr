package com.kazarmax;

public class Computer {

    public final String name = "Computer";
    public char ownCellValue = 'o';
//    public char enemyCellValue = 'x';
//    public int cellCoordinateI = -1;
//    public int cellCoordinateJ = -1;

    Field field;


    public void fillEmptyCell() {
        search:
        for (int i = 0; i < field.getFieldSize(); i++) {
            for (int j = 0; j < field.getFieldSize(); j++) {
                if (field.isCellEmpty(i, j)) {
                    field.setFieldCellIndexI(i);
                    field.setFieldCellIndexJ(j);
                    fillCell();
                    break search;
                }
            }
        }
    }

    public void fillCell() {
        field.setFieldCell(ownCellValue);
    }

    public boolean isWinner() {
        return field.isWin(ownCellValue);
    }

    public void makeMove() {
        System.out.println("**************************************************");
        System.out.println("Ход компьютера ...");
        fillEmptyCell();
    }

//    public void showField() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print("[" + testField[i][j] + "]");
//            }
//            System.out.println();
//        }
//
//    }

    //    public boolean checkHorLine(char playerCellValue) {
//        boolean checkHorLine = false;
//        int cellCount = 0;
//        search:
//        for (int i = 0; i < 3; i++) {
//            cellCount = 0;
//            for (int j = 0; j < 3; j++) {
//                if (testField[i][j] == playerCellValue) {
//                    cellCount++;
//                }
//            }
//            if (cellCount == 2) {
//                checkHorLine = true;
//                System.out.println("i = " + i);
//                findHorCell(i);
//                break search;
//            }
//        }
//        System.out.println("checkHorLine = " + checkHorLine);
//        return checkHorLine;
//    }
//
//    public void findHorCell(int lineNumber) {
//        for (int j = 0; j < 3; j++) {
//            if (testField[lineNumber][j] == ' ') {
//                System.out.println("j = " + j);
//                cellCoordinateI = lineNumber;
//                cellCoordinateJ = j;
//                fillCell();
//                showField();
//
//            }
//        }
//    }

//        public boolean checkVertLine(char playerCellValue) {
//        boolean checkVertLine = false;
//        int cellCount = 0;
//        for (int i = 0; i < 3; i++) {
//            cellCount = 0;
//            for (int j = 0; j < 3; j++) {
//                if (testField[j][i] == playerCellValue) {
//                    cellCount++;
//                }
//            }
//            if (cellCount == 2) {
//                checkVertLine = true;
//                System.out.println("j = " + i);
//                findVertCell(i);
//            }
//        }
//        System.out.println("checkVertLine = " + checkVertLine);
//        return checkVertLine;
//    }
//
//    public void findVertCell(int lineNumber) {
//        for (int i = 0; i < 3; i++) {
//            if (testField[i][lineNumber] == ' ') {
//                System.out.println("i = " + i);
//                cellCoordinateI = i;
//                cellCoordinateJ = lineNumber;
//                fillCell();
//            }
//        }
//    }
//
//    public boolean checkMainDiag(char playerCellValue) {
//        boolean checkMainDiag = false;
//        int cellCount = 0;
//            for (int i = 0; i < 3; i++) {
//                if (testField[i][i] == playerCellValue) {
//                    cellCount++;
//                }
//            }
//            if (cellCount == 2) {
//                checkMainDiag = true;
//                findMainDiagCell();
//                fillCell();
//            }
//        System.out.println("checkMainDiag = " + checkMainDiag);
//        return checkMainDiag;
//    }
//
//    public void findMainDiagCell() {
//        for (int i = 0; i < 3; i++) {
//                if (testField[i][i] == ' ') {
//                    cellCoordinateI = i;
//                    cellCoordinateJ = i;
//                    System.out.println("i = " + i);
//                }
//        }
//    }
//
//    public boolean checkSubDiag(char playerCellValue) {
//        boolean checkSubDiag = false;
//        int cellCount = 0;
//        for (int i = 0; i < 3; i++) {
//            if (testField[i][3 - i -1] == playerCellValue) {
//                cellCount++;
//            }
//        }
//        if (cellCount == 2) {
//            checkSubDiag = true;
//            findSubDiagCell();
//            fillCell();
//        }
//        System.out.println("checkSubDiag = " + checkSubDiag);
//        return checkSubDiag;
//    }
//
//    public void findSubDiagCell() {
//        for (int i = 0; i < 3; i++) {
//            if (testField[i][3 - i -1] == ' ') {
//                cellCoordinateI = i;
//                cellCoordinateJ = 3 - i -1;
//                System.out.println("i = " + i);
//                System.out.println("j = " + cellCoordinateJ);
//            }
//        }
//    }

//    public boolean isCellEmpty(int coordinateI, int coordinateJ) {
//        return testField[coordinateI][coordinateJ] == ' ';
//    }


}
