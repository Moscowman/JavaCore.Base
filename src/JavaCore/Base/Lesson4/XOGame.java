package JavaCore.Base.Lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final int SIZE = 5;
    static final int DOT_TO_WIN = 4;
    static final int AI_CHECK_DEPTH = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(map, DOT_X)) {
                System.out.println("Вы победили! Поздравляем!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(map, DOT_O)) {
                System.out.println("Компьютер победил.");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("input X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x;
        int y;

        int[] move = checkForBestMove(DOT_X, DOT_O);
        x = move[1];
        y = move[0];
        if (!isCellValid(y, x)) {
            System.out.println("Внутренняя ошибка искусственного интеллекта!!!");
        }
        ;

        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char[][] mapToCheck, char c) {
        for (int i = 0; i < SIZE; i++) {
            int horizontalWin = 0;
            int verticalWin = 0;
            for (int j = 0; j < SIZE; j++) {
                if (mapToCheck[i][j] != c) {
                    horizontalWin = 0;
                } else {
                    horizontalWin++;
                }

                if (mapToCheck[j][i] != c) {
                    verticalWin = 0;
                } else {
                    verticalWin++;
                }
                if (horizontalWin >= DOT_TO_WIN || verticalWin >= DOT_TO_WIN)
                    return true;
            }
        }
        for (int i = 0; i <= SIZE - DOT_TO_WIN; i++) {
            for (int j = 0; j <= SIZE - DOT_TO_WIN; j++) {
                int diagonal1 = 0;
                int diagonal2 = 0;
                for (int k = 0; k < DOT_TO_WIN; k++) {
                    if (mapToCheck[i + k][j + k] != c) {
                        diagonal1 = 0;
                    } else {
                        diagonal1++;
                    }
                    if (mapToCheck[i + k][SIZE - j - k - 1] != c) {
                        diagonal2 = 0;
                    } else {
                        diagonal2++;
                    }
                }
                if (diagonal1 >= DOT_TO_WIN || diagonal2 >= DOT_TO_WIN) {
                    return true;
                }

            }
        }
        return false;
    }

    public static int[] checkForBestMove(char enemy, char my) {
        double bestMoveWeight = -10000.0;
        int bestMoveX = -1;
        int bestMoveY = -1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != DOT_EMPTY) {
                    continue;
                }
                char[][] newMap = new char[SIZE][];
                for (int k = 0; k < SIZE; k++) {
                    newMap[k] = Arrays.copyOf(map[k], SIZE);
                }
                newMap[i][j] = DOT_O;
                double weight = checkForBestMoveRecursive(newMap, enemy, my, false, 0);
                if (weight > bestMoveWeight) {
                    bestMoveWeight = weight;
                    bestMoveX = i;
                    bestMoveY = j;
                }
            }
        }
        return new int[]{bestMoveX, bestMoveY};
    }

    public static double checkForBestMoveRecursive(char[][] mapToCheck, char enemy, char my, boolean isMyMove, int depth) {
        if (depth >= AI_CHECK_DEPTH) {
            return 0.5;
        }

        double win = 0.0;
        boolean enemyWin = checkWin(mapToCheck, enemy);
        if (enemyWin) {
            win = -100;
        }
        boolean myWin = checkWin(mapToCheck, my);
        if (myWin) {
            win = 1.0;
        }
        if (myWin || enemyWin) {
            return win;
        }

        double sumOfWeights = 0.0;
        double movesChecked = 0.0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mapToCheck[i][j] == DOT_EMPTY) {
                    char[][] newMap = new char[SIZE][];
                    for (int k = 0; k < SIZE; k++) {
                        newMap[k] = Arrays.copyOf(mapToCheck[k], SIZE);
                    }
                    newMap[i][j] = isMyMove ? my : enemy;
                    sumOfWeights += checkForBestMoveRecursive(newMap, enemy, my, !isMyMove, depth + 1);
                    movesChecked++;
                }
            }
        }
        return sumOfWeights / movesChecked;
    }

}
