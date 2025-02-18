import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

    private static final int gameFieldSize = 3;
    private static String[][] gameField = new String[gameFieldSize][gameFieldSize];
    private static boolean isGame = true;
    private static boolean flag = false;

    public static void main(String[] args) {
        while (isGame) {
            initGameField();
            printGameField();
            toGameField();
        }
    }

    public static void initGameField() {
        for (int i = 0; i < gameFieldSize; i++) {
            for (int j = 0; j < gameFieldSize; j++) {
                gameField[i][j] = "*";
            }
        }
    }

    public static void printGameField() {
        System.out.println("Это игра крестики-нолики!" +
                "Вводите строку в формате: Х или O, затем цифры, показывающие номер клетки, в какой находится символ" +
                "Начинают X");
        for (int i = 0; i < gameFieldSize; i++) {
            if (i == 0) System.out.print("  " + i);
            else System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= gameFieldSize; i++) {
            System.out.print(i - 1 + " ");
            for (int j = 1; j <= gameFieldSize; j++) {
                System.out.print(gameField[i - 1][j - 1] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkGameField() {
        while (isGame) {
            for (int i = 0; i < gameFieldSize; i++) {
                for (int j = 0; j < gameFieldSize; j++) {
                    if (gameField[i][j].equals("*")) {
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public static void toGameField() {
        String symNow;
        String symBefore = "1";
        while (checkGameField()) {

            Scanner sc = new Scanner(System.in);
            String[] str = sc.nextLine().split(" ");
            symNow = str[0];
            if (symNow.equals("X") && symBefore.equals("1")) {
                if (str[0].equals("X") || (str[0].equals("O"))) {
                    if (gameField[Integer.parseInt(str[1])][Integer.parseInt(str[2])].equals("*")) {
                        gameField[Integer.parseInt(str[1])][Integer.parseInt(str[2])] = str[0];

                    } else
                        System.out.println("Здесь уже занято!");
                } else {
                    System.out.println("Вы ввели не тот символ! Доступны только: 'X' или 'O'");
                }
                symBefore = symNow;
            }else if(symNow.equals("O") && symBefore.equals("X")) {
                if (str[0].equals("X") || (str[0].equals("O"))) {
                    if (gameField[Integer.parseInt(str[1])][Integer.parseInt(str[2])].equals("*")) {
                        gameField[Integer.parseInt(str[1])][Integer.parseInt(str[2])] = str[0];

                    } else
                        System.out.println("Здесь уже занято!");
                } else {
                    System.out.println("Вы ввели не тот символ! Доступны только: 'X' или 'O'");
                }
                symBefore = symNow;
            }else if(symNow.equals("X") && symBefore.equals("O")) {
                if (str[0].equals("X") || (str[0].equals("O"))) {
                    if (gameField[Integer.parseInt(str[1])][Integer.parseInt(str[2])].equals("*")) {
                        gameField[Integer.parseInt(str[1])][Integer.parseInt(str[2])] = str[0];

                    } else
                        System.out.println("Здесь уже занято!");
                } else {
                    System.out.println("Вы ввели не тот символ! Доступны только: 'X' или 'O'");
                }
                symBefore = symNow;
            }else{
                System.out.println("После X идёт O и наоборот!");
            }
            printGameField();
            win();

        }

    }

    public static void win() {
        if (gameField[0][0].equals(gameField[1][1]) && gameField[1][1].equals(gameField[2][2]) && (gameField[0][0].equals("X") || gameField[0][0].equals("O"))) {
            System.out.println("Победили: " + gameField[0][0]);
            isGame = false;
        } else if (gameField[0][0].equals(gameField[0][1]) && gameField[0][1].equals(gameField[0][2]) && (gameField[0][0].equals("X") || gameField[0][0].equals("O"))) {
            System.out.println("Победили: " + gameField[0][0]);
            isGame = false;
        } else if (gameField[1][0].equals(gameField[1][1]) && gameField[1][1].equals(gameField[1][2]) && (gameField[1][0].equals("X") || gameField[1][0].equals("O"))) {
            System.out.println("Победили: " + gameField[1][0]);
            isGame = false;
        } else if (gameField[2][0].equals(gameField[2][1]) && gameField[2][1].equals(gameField[2][2]) && (gameField[2][0].equals("X") || gameField[2][0].equals("O"))) {
            System.out.println("Победили: " + gameField[2][0]);
            isGame = false;
        } else if (gameField[0][1].equals(gameField[1][1]) && gameField[1][1].equals(gameField[2][1]) && (gameField[0][1].equals("X") || gameField[0][1].equals("O"))) {
            System.out.println("Победили: " + gameField[0][1]);
            isGame = false;
        } else if (gameField[0][2].equals(gameField[1][2]) && gameField[1][2].equals(gameField[2][2]) && (gameField[0][2].equals("X") || gameField[0][2].equals("O"))) {
            System.out.println("Победили: " + gameField[2][2]);
            isGame = false;
        }
    }
}
