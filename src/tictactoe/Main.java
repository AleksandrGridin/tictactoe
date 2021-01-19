package tictactoe;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final char[][] tic = new char[3][3];

    public static void main(String[] args) {
        init();
        doStep();
    }

    private static void init() {
        for (int i = 0; i < tic.length; i++) {
            for (int j = 0; j < tic[i].length; j++) {
                tic[i][j] = ' ';
            }
        }
        print();
    }

    private static void print() {
        System.out.println("---------");
        for (int i = 0; i < tic.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < tic[i].length; j++) {
                System.out.print(tic[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean checkResult(char[][] grid) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(grid[0][0]) + grid[0][1] + grid[0][2]);
        list.add(String.valueOf(grid[1][0]) + grid[1][1] + grid[1][2]);
        list.add(String.valueOf(grid[2][0]) + grid[2][1] + grid[2][2]);
        list.add(String.valueOf(grid[0][0]) + grid[1][0] + grid[2][0]);
        list.add(String.valueOf(grid[0][1]) + grid[1][1] + grid[2][1]);
        list.add(String.valueOf(grid[0][2]) + grid[1][2] + grid[2][2]);
        list.add(String.valueOf(grid[0][0]) + grid[1][1] + grid[2][2]);
        list.add(String.valueOf(grid[0][2]) + grid[1][1] + grid[2][0]);

        String result = "";
        boolean truResult = false;
        for (String r : list) {
            if (r.equals("XXX") || r.equals("OOO")) {
                result = r;
                truResult = true;
                System.out.println(result.charAt(0) +" wins");
            }
        }
        return truResult;
    }

    private static void doStep() {
        int i = 0;
        char xOrY = 'X';
        while (i != 9) {
            System.out.print("Enter the coordinates: ");
            String[] step = scanner.nextLine().trim().split(" ");
            try {
                int one = Integer.parseInt(step[0]) - 1;
                int two = Integer.parseInt(step[1]) - 1;

                if (tic[one][two] == ' ') {
                    tic[one][two] = xOrY;
                    print();
                    if (checkResult(tic)) {
                        break;
                    }
                    if (xOrY == 'X') {
                        xOrY = 'O';
                    } else {
                        xOrY = 'X';
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                i++;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
        if (i == 9) {
            System.out.println("Draw");
        }

    }
}
