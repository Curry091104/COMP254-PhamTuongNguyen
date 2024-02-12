package PhamTuongNguyen_COMP254Lab3_Ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the string: ");
        String m = sc.next();
        if(isPalindrome2(m, 0, m.length() - 1)){
            System.out.printf("%s is a palindrome\n", m);
        }
        else{
            System.out.printf("%s is NOT a palindrome\n", m);
        }
        sc.close();
    }
    public static boolean isPalindrome(String str){
        if(str.length() == 1 || str.length() == 0) return true;
        else return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome(str.substring(1, str.length() - 1));
    }
    //Alternative
    public static boolean isPalindrome2(String str, int s, int e){
        if(s >= e) return true;
        else return str.charAt(s) == str.charAt(e) && isPalindrome2(str, s + 1, e - 1);
    }
}
