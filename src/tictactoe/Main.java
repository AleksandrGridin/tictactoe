package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        char[] line = scanner.nextLine().trim().toCharArray();
        System.out.println("---------");

        for (int i = 3; i <= line.length; i = i + 3) {
            System.out.println("| " + line[i - 3] + " " + line[i - 2] + " " + line[i - 1] + " |");
        }

        System.out.println("---------");
    }
}
