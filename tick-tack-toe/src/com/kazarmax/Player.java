package com.kazarmax;

import java.util.Scanner;

public class Player {

    public String name;

    public char ownCellValue;

    Field field;

    public String getName() {

        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        return name;
    }

    public void makeMove() {
        field.getFieldCellCoordinates(name);
        field.setFieldCell(ownCellValue);
    }

    public boolean isWinner() {
        return field.isWin(ownCellValue);
    }


}
