/**
 * Use generics to replace betterString with betterEntry and TwoStringPredicate
 * with TwoElementPredicate. Make sure your previous examples still work when
 * you only change betterString to betterElement.
 *
 */
 public class BetterElement {
     public static <T> T betterElement(T first, T second, TwoElementPredicate<T> predicate) {
         if (predicate.test(first, second)) {
             return first;
         } else {
             return second;
         }
     }

     public static void main(String[] args) {
         String test1 = "java";
         String test2 = "hello";
         String best = betterElement(test1, test2, (s1, s2) -> s1.length() > s2.length());
         System.out.println(best);

         best = betterElement(test1, test2, (s1, s2) -> true);
         System.out.println(best);
     }
 }

 interface TwoElementPredicate<T> {
     boolean test(T first, T second);
 }