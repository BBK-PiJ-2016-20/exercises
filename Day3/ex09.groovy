/*
Write a program that reads some text from the user and then says how many letters ’e’ are there in that text.
*/

print "Enter some text: "
String s = System.console().readLine()

int es = 0

for (int i = 0; i < s.size(); i++) {
	if (s.charAt(i) == 'e') {
		es++
	}
}

println "\"" + s + "\" contains " + es + " letter 'e's"