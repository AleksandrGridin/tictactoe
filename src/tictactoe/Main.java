package tictactoe;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String fromUserLine = scanner.nextLine().trim();
        char[] line = fromUserLine.toCharArray();
        char[][] tic = new char[3][3];
        System.out.println("---------");

        int y = 0;
        for (int i = 0; i < tic.length; i++) {
            for (int j = 0; j < tic[i].length; j++) {
                tic[i][j] = line[y];
                y++;
            }
        }


        for (int i = 0; i < tic.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < tic[i].length; j++) {
                System.out.print(tic[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        getResult(fromUserLine);
    }

    private static void getResult(String fromUserLine) {
        int getOfromLine = (int) fromUserLine.chars().filter(s -> s == 'O').count();
        int getXfromLine = (int) fromUserLine.chars().filter(s -> s == 'X').count();
        if (Math.abs(getOfromLine - getXfromLine) >= 2) {
            System.out.println("Impossible");
            return;
        }
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(fromUserLine.charAt(0)) + fromUserLine.charAt(1) + fromUserLine.charAt(2));
        list.add(String.valueOf(fromUserLine.charAt(3)) + fromUserLine.charAt(4) + fromUserLine.charAt(5));
        list.add(String.valueOf(fromUserLine.charAt(6)) + fromUserLine.charAt(7) + fromUserLine.charAt(8));
        list.add(String.valueOf(fromUserLine.charAt(0)) + fromUserLine.charAt(3) + fromUserLine.charAt(6));
        list.add(String.valueOf(fromUserLine.charAt(1)) + fromUserLine.charAt(4) + fromUserLine.charAt(7));
        list.add(String.valueOf(fromUserLine.charAt(2)) + fromUserLine.charAt(5) + fromUserLine.charAt(8));
        list.add(String.valueOf(fromUserLine.charAt(0)) + fromUserLine.charAt(4) + fromUserLine.charAt(8));
        list.add(String.valueOf(fromUserLine.charAt(2)) + fromUserLine.charAt(4) + fromUserLine.charAt(6));

        String result = "";
        boolean truResult = true;
        for (String r : list) {
            if (r.equals("XXX") || r.equals("OOO")) {
                if (!result.isEmpty()) {
                    truResult = false;
                }
                result = r;
            }
        }
        if (truResult) {
            if (result.isEmpty()) {
                if (fromUserLine.contains("_")) {
                    System.out.println("Game not finished");
                    return;
                }
                System.out.println("Draw");
                return;
            }
            System.out.println(result.charAt(0) + " wins");
        } else {
            System.out.println("Impossible");
        }
    }
}
