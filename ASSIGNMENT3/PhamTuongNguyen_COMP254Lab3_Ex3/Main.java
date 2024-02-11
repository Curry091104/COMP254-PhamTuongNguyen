package PhamTuongNguyen_COMP254Lab3_Ex3;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the filename you are finding: ");
        String filename = sc.next();
        find(new File("D:/Centennial College Materials/FOURTH SEMESTER/COMP 254 - DATA STRUCTURES AND ALGORITHMS"), filename);
        sc.close();
    }

    public static void find(File path, String filename) {
        if (path.isDirectory()) {
            for (File child : path.listFiles()) {
                if (child.getName().equals(filename)) {
                    System.out.println("\n\nFound: " + child.getAbsolutePath() + "\n\n");
                } else {
                    find(child, filename);
                }
            }
        }
    }
}
