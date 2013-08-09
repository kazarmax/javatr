package com.kazarmax;



public class Main {

    public static void main(String[] args) {
//        Field field = new Field(5);
//        field.eraseField();
//        field.showFields();
//
//        while (field.FieldNotFull()) {
//            field.setFieldCell();
//            if (field.isWin()) {
//                System.out.println("Вы выиграли! Игра закончена.");
//                break;
//            }
//        }

    System.out.println("**************************************************");
    System.out.println("****" + " Добро пожаловать в игру Крестики-Нолики! " + "****");
    System.out.println("**************************************************");
    System.out.println();

    Player player1 = new Player();
    System.out.println("Введите имя или ник первого игрока:");
    player1.getName();
    player1.ownCellValue = 'x';
    System.out.println("Добро пожаловать в игру, " + player1.name + "!" + " Вы будете играть крестиками - x.");

    System.out.println();
    Player player2 = new Player();
    System.out.println("Введите имя или ник второго игрока:");
    player2.getName();
    player2.ownCellValue = 'o';
    System.out.println("Добро пожаловать в игру, " + player2.name + "!" + " Вы будете играть ноликами - o.");

    System.out.println();
    System.out.println("************************************************************");
    System.out.println();

    player1.field = new Field();
    player2.field = player1.field;
    player1.field.eraseField();
    player1.field.showFields();
    player1.makeMove();
    player2.makeMove();




    }

}
