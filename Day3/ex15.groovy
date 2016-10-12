/*
A strict palindrome is difficult to see in every day language. A relaxed palindrome, a text 
that is a palindrome if you ignore punctuation marks such as commas or spaces, is easier to 
see. Examples include “A man, a plan, a canal - Panama!”, “Was it a car or a cat I saw?”, 
and “Rise to vote, sir”. Write a program that reads a text from the user and then says 
whether the text is a relaxed palindrome. Note that all strict palindromes are relaxed 
palindromes by definition.
*/

print "Enter some text: "
String candidate = System.console().readLine()

String normalized = ""

for (int i = 0; i < candidate.size(); i++) {
  char c = candidate.charAt(i)
  if (Character.isLetter(c)) {
    normalized += Character.toLowerCase(c)
  }
}

boolean isPalindrome = true

for (int i = 0; i <= normalized.size() / 2; i++ ) {
  if (normalized.charAt(i) != normalized.charAt(normalized.size() - i - 1)) {
    isPalindrome = false
    break
  }
}

String message

if (isPalindrome) {
  message = "is a relaxed palindrome" 
} else {
  message = "is NOT a relaxed palindrome"
}

println "\"" + candidate + "\" " + message
