package PhamTuongNguyen_COMP254Lab3_Ex1;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the first integer value: ");
        int m = sc.nextInt();
        System.out.print("Please enter the second integer value: ");
        int n = sc.nextInt();
        System.out.println("Product of two positive integers: " + productTwoInteger(m,n));
        sc.close();
    }
    public static int productTwoInteger(int m, int n){
        if(n == 1) return m;
        else return m + productTwoInteger(m, n - 1);
    }
}