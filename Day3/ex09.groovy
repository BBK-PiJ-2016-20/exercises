/*
Write a program that reads some text from the user and then says how many letters ’e’ are there in that text.
Then modify the program so that it reads the text from the user and then asks for a letter. The program should
then say how many times you can find the letter in the text.
*/

print "Enter some text: "
String s = System.console().readLine()

char toCount
boolean charEntered = false

while (!charEntered) {
	print "Enter a character to count: "
	String c = System.console().readLine()
	if (c.length() != 1) {
		println "Enter exactly one character"
	} else {
		toCount = c.charAt(0)
		charEntered = true
	}
}

int counted = 0

for (int i = 0; i < s.size(); i++) {
	if (s.charAt(i) == toCount) {
		counted++
	}
}

println "\"" + s + "\" contains " + counted + " letter '" + toCount + "'s"