/* 
Write a program that reads a text and then writes on the screen a palindrome by writing the 
same text followed by the same text in reversed order. For example, if the user enters the 
text “It was a dark and stormy night” the program must output “It was a dark and stormy 
nightthgin ymrots dna krad a saw tI”.
*/

print "Enter some text: "
String str = System.console().readLine()

print str

for (int i = str.size() - 1; i >= 0; i--) {
  print str.charAt(i)
}

println ""

