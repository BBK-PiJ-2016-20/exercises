/*
Write a program that reads two numbers from the user and then offers a menu with the four basic operations:
addition, subtraction, multiplication, and division. Once the user has selected an operation from the menu, the
calculator performs the operation.
*/

print "Enter a number (x): "
double x = Double.parseDouble(System.console().readLine())

print "Enter a number (y): "
double y = Double.parseDouble(System.console().readLine())


double result
String symbol

boolean retry = true
while (retry) {
	retry = false

	println "Operation: "
	println "1. x + y"
	println "2. x - y"
	println "3. x * y"
	println "4. x / y"
	
	int operation = Integer.parseInt(System.console().readLine())

	switch (operation) {
		case 1:
			symbol = "+"
			result = x + y
			break
		case 2:
			symbol = "-"
			result = x - y
			break
		case 3:
			symbol = "*"
			result = x * y
			break
			case 4:
			symbol = "/"
			result = x / y
			break
		default:
			println "Enter 1, 2, 3, 4 to choose the operation"
			retry = true
	}
}

println x + " " + symbol + " " + y + " = " + result