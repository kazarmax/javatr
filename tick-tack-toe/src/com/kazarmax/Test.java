package com.kazarmax;

public class Test {

    public char[][] testArray = {{'x',' ',' '},
                                 {' ','x',' '},
                                 {' ',' ','x'}};



    public void checkTestMainDiag() {
        int foundCells = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.println("j = " + j);
                System.out.println();
                if (testArray[i][i] == 'x') {
                    foundCells++;
                    break;
                }
                System.out.println("foundCells = " + foundCells);
                System.out.println();
            }
            System.out.println("*************");
        }
        System.out.println("foundCells = " + foundCells);
    }


}