/*
Write a program that reads some text from the user and then writes the same text on screen, but each letter on a
different line.
Now modify your program to write each word (as defined by spaces) rather than letter on a different line.
*/

print "Enter some text: "
String s = System.console().readLine()

boolean lastWasSpace = false

for (int i = 0; i < s.size(); i++) {
	char c = s.charAt(i)
	if (c == ' ') {
		if (!lastWasSpace) {
			println ""
		}
		lastWasSpace = true
	} else {
		lastWasSpace = false
		print c
	}
}
