package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give no of rows : ");
        int rows = scanner.nextInt();
        System.out.println("Give no of columns : ");
        int columns = scanner.nextInt();

        Board board = new Board(rows, columns);
        board.printBoard();
        System.out.println("===========================");

        while (true) {

            System.out.println("Enter 1 to populate");
            System.out.println("Enter 2 to print nextLife");
            System.out.println("Enter 3 to exit");
            int n = scanner.nextInt();
            if (n == 1) {
                board.populate();
                board.printBoard();
                System.out.println("===========================");
            }
            if (n == 2) {
                board = board.boardForNextGeneration();
                board.printBoard();
                System.out.println("===========================");
            }
            if (n == 3) {
                break;
            }
            if (n != 1 && n != 2 && n != 3) {
                System.out.println("Please enter valid option");
                System.exit(0);
            }
        }

        System.out.println("Thank you for playing the game");

    }
}