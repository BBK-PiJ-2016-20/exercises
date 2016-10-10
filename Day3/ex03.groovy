/*
Write a program that reads a text representing a mathematical operation (one of the four basic ones) with two
operands, and then execute it. For example, if the user enters “3/5” the program outputs “0.6”; if the user
enters “23 * 4” the program outputs “92”.
*/

print "Enter an expression with one operand: "

String expr = System.console().readLine()

String left = ""
String right = ""
char operator

for (int i = 0; i < expr.size(); i++) {
	char c = expr.charAt(i)
	switch (c) {
		case ' ':
			// Ignore space
			break
		case '+':
		case '-':
		case '*':
		case '/':
			operator = c
			left = right
			right = ""
			break
		default:
			right += c
	}
}

double y = Double.parseDouble(right)
double x = Double.parseDouble(left)

double result

switch (operator) {
	case '+':
		result = x + y
		break
	case '-':
		result = x - y
		break
	case '*':
		result = x * y
		break
	case '/':
		result = x / y
		break
}

print result
