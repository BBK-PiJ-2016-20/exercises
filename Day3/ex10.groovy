/*
Write a program that reads a short string and then some longer text. The program must say how many times you
can find the short string in the text. You cannot use any method of String apart from charAt() and length().
*/

print "Enter a string to look for: "
String needle = System.console().readLine()

print "Enter a string to look in: "
String haystack = System.console().readLine()

int needlep = 0
int found = 0

for (int i = 0; i < haystack.length(); i++) {
	int j
	for (j = 0; j < needle.length() && (i + j) < haystack.length(); j++) {
		if (haystack.charAt(i + j) != needle.charAt(j)) {
			break;
		}
	}
	if (j == needle.length()) {
		// j == needle.length() because all characters in needle matched the characters in haystack
		found++
	}	
}

println "\"" + needle + "\" appears " + found + " times in \"" + haystack + "\""