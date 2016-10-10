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

int i = 0

while (i < haystack.length()) {
	if (haystack.charAt(i) == needle.charAt(needlep)) {
		needlep++
		if (needlep == needle.length()) {
			found++
			needlep = 0
		}
		i++ 
	} else {
		if (needlep != 0 ) {
			needlep = 0
		} else {
			i++
		}
	}
}

println "\"" + needle + "\" appears " + found + " times in \"" + haystack + "\""