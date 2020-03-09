package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var table = new Table();
        table.field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table.field[i][j] = ' ';
            }
        }

        var turnX = true;
        Table.printTicTacToeField(table.field);

        while (Table.findGameState(table.field).equals("Game not finished")) {

            boolean inputIsCorrect = false;
            int cord1 = -1;
            int cord2 = -1;

            System.out.println("Enter the coordinates: ");

            while (!inputIsCorrect) {
                if (scanner.hasNextInt() && (cord1 = scanner.nextInt()) == cord1 && scanner.hasNextInt()) {
                    cord2 = scanner.nextInt();
                    if (1 <= cord1 && cord1 <= 3 && 1 <= cord2 && cord2 <= 3) {
                        var turnPosition = table.field[3 - cord1][cord2 - 1];
                        if (turnPosition != 'X' && turnPosition != 'O') {
                            inputIsCorrect = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }
            }

            table.field[3 - cord1][cord2 - 1] = (turnX) ? 'X' : 'O';
            turnX = !turnX;

            Table.printTicTacToeField(table.field);
        }
        System.out.println(Table.findGameState(table.field));
    }
}
