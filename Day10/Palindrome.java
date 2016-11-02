/**
 * Create a program with a (recursive) method that takes a String paremeter and
 * returns true if the String is a palindrome and false otherwise
 */

public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        String s;
        if (args.length < 1) {
            s = "amanaplanacanalpanama";
        } else {
            s = args[0];
        }
        
        if (isPalindrome(s)) {
            System.out.println(s + " is a palindrome");
        } else {
            System.out.println(s + " is not a palindrome");
        }
    }
}