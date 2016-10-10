/*
Write a program that reads a text from the user and then enter a loop of requesting letters and counting them.
The program stops if the user asks for the same letter twice.
*/

print "Enter some text: "
String s = System.console().readLine()

boolean finished = false

Character last = null

while (!finished) {
	char toCount
	boolean charEntered = false

	while (!charEntered) {
		print "Which letter would you like to count now? "
		String c = System.console().readLine()
		if (c.length() != 1) {
			println "Enter exactly one character"
		} else {
			toCount = c.charAt(0)
			charEntered = true
		}
	}

	if (last != null && toCount == last) {
		finished = true
	} else {
		last = toCount
		int counted = 0
	
		for (int i = 0; i < s.size(); i++) {
			if (s.charAt(i) == toCount) {
				counted++
			}
		}
	
		println "\"" + s + "\" contains " + counted + " letter '" + toCount + "'s"
	}
}

println "Thank you for you cooperation. Goodbye!"