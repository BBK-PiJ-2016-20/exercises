/*
A palindrome is a word, phrase, number, or other sequence of units that may be read the same way in either
direction. Examples of strict palindromes include “ABBA”, “madam”, “radar”, “kayak”, and “step on no pets”.
Write a program that reads a text and detects whether the text is a strict palindrome.
*/

print "Enter text: "
String str = System.console().readLine()

boolean isPalindrome = true

for (int i = 0; i < (str.size() / 2 + 1); i++) {
	if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
		isPalindrome = false
		break
	}
}

if (isPalindrome) {
	println "\"" + str + "\" is a palindrome"
} else {
	println "\"" + str + "\" is NOT a palindrome"
}