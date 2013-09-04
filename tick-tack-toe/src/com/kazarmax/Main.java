package com.kazarmax;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    System.out.println();
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
    Computer player2 = new Computer();
//    System.out.println("Введите имя или ник второго игрока:");
   // player2.getName();
   // player2.ownCellValue = 'o';
//    System.out.println("Добро пожаловать в игру, " + player2.name + "!" + " Вы будете играть ноликами - o.");
    System.out.println("Компьютер будет играть ноликами - o.");

    System.out.println();
    System.out.println("************************************************************");
    System.out.println();
    System.out.println("Игровое поле:");
    player1.field = new Field();
    player2.field = player1.field;
    player1.field.eraseField();
    player1.field.showFields();

    while (!player1.field.isFull()) {
        player1.makeMove();
        if (player1.isWinner()) {
            System.out.println(player1.name + " выиграл! Игра закончена!");
            break;
        } else if (player1.field.isFull()) {
            System.out.println("Ничья!");
            break;
        }

        player2.makeMove();
        if (player2.isWinner()) {
            System.out.println(player2.name + " выиграл! Игра закончена!");
            break;
        } else if (player2.field.isFull()) {
            System.out.println("Ничья!");
            break;
        }
    }


    }

}
