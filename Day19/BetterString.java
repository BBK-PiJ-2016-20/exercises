/**
 * Create a class with a static method called betterString. This method should
 * take two Strings and a lambda as its arguments. This lambda states whether
 * the first of the two strings is better. The method should return the better
 * string; i.e., if the lambda returns true the method should return the first
 * string, otherwise it should return the second string. For the lambda, define
 * an interface called TwoStringPredicate with a method that takes two Strings
 * and returns true if the first is better than the second, false otherwise.
 */
 public class BetterString {
     public static String betterString(String first, String second, TwoStringPredicate predicate) {
         if (predicate.test(first, second)) {
             return first;
         } else {
             return second;
         }
     }

     public static void main(String[] args) {
         String test1 = "java";
         String test2 = "hello";
         String best = betterString(test1, test2, (s1, s2) -> s1.length() > s2.length());
         System.out.println(best);

         best = betterString(test1, test2, (s1, s2) -> true);
         System.out.println(best);
     }
 }

 interface TwoStringPredicate {
     boolean test(String first, String second);
 }