package com.kazarmax;



public class Main {

    public static void main(String[] args) {
        Field field = new Field(5);
        field.eraseField();
        field.showFields();

        while (field.FieldNotFull()) {
            field.setFieldCell();
            if (field.isWin()) {
                System.out.println("Вы выиграли! Игра закончена.");
                break;
            }
        }





    }

}
