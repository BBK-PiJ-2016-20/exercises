/*
Write a program that reads some text from the user and then writes the same text on screen, but each letter on a
different line.
*/

print "Enter some text: "
String s = System.console().readLine()

for (int i = 0; i < s.size(); i++) {
	println s.charAt(i)
}
