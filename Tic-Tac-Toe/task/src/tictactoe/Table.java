package tictactoe;

import java.util.Arrays;

public class Table {
    char[][] field;

    public static String findGameState(char[][] field) {

        String stringXO = Arrays.deepToString(field);
        var numberOfX = stringXO.length() - stringXO.replace("O", "").length();
        var numberOfO = stringXO.length() - stringXO.replace("X", "").length();
        var numberOfEmptyCells = 9 - numberOfX - numberOfO;
        if (Math.abs(numberOfX - numberOfO) > 1) {
            return "Impossible";
        }

        var xHoriz3InRow = horiz3InRow(field, 'X');
        var xVert3InRow = vert3InRow(field, 'X');
        var xDiag3InRow = diag3InRow(field, 'X');
        var oHoriz3InRow = horiz3InRow(field, 'O');
        var oVert3InRow = vert3InRow(field, 'O');
        var oDiag3InRow = diag3InRow(field, 'O');

        var x3InRow = xHoriz3InRow || xVert3InRow || xDiag3InRow;
        var o3InRow = oHoriz3InRow || oVert3InRow || oDiag3InRow;

        if (x3InRow) {
            return "X wins";
        } else if (o3InRow) {
            return "O wins";
        } else if (numberOfEmptyCells != 0){
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    public static void printTicTacToeField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++)
            System.out.println(String.format("| %c %c %c |", field[i][0], field[i][1], field[i][2]));
        System.out.println("---------");
    }

    public static boolean horiz3InRow(char[][] symbols, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (symbol == symbols[i][0] && symbol == symbols[i][1] && symbol == symbols[i][2]) {
                return true;
            }
        }
        return false;
    }

    public static boolean vert3InRow(char[][] symbols, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (symbol == symbols[0][i] && symbol == symbols[1][i] && symbol == symbols[2][i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean diag3InRow(char[][] symbols, char symbol) {
        return symbol == symbols[0][0] && symbol == symbols[1][1] && symbol == symbols[2][2] || symbol == symbols[0][2] && symbol == symbols[1][1] && symbol == symbols[2][0];
    }
}
