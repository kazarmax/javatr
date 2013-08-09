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

    public void manSetFieldCell(int x, int y) {
        field.manSetFieldCell(x, y, ownCellValue);
    }

    public void makeMove() {
        field.getFieldCellCoordinates(name);
        field.setFieldCell(ownCellValue);
    }


}
