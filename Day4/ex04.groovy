/*
Write a program that takes a String. The string can be a decimal or a hexadecimal number (starting by “0x”).
Your program must recognise the number as what it is and convert it to the other base. Use two methods for
conversion as in the former exercise.
*/

// Verifies that a string is a valid number in hexidecimal format (including the 0x prefix)
boolean verifyHex(String hex) {
	if (hex.charAt(0) != '0') {
		return false
	}
	if (hex.charAt(1) != 'x') {
		return false
	}
	for (int i = 2; i < hex.size(); i++) {
		char c = hex.charAt(i)
		if (!Character.isDigit(c) && c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f') {
			return false
		}
	}

	return true
}

// Verifies that a string is a valid number in decimal format
boolean verifyDecimal(String decimal) {
	for (int i = 0; i < decimal.size(); i++) {
		if (!Character.isDigit(decimal.charAt(i))) {
			return false
		}
	}
	return true
}

int parseHex(String hex) {
	int result = 0
	boolean error = false
	for (int i = 0; i < hex.size() && !error; i++) {
		int digit
		switch (hex.charAt(i)) {
			case '0':
				digit = 0
				break
			case '1': 	
				digit = 1
				break
			case '2':
				digit = 2
				break
			case '3':
				digit = 3
				break
			case '4':
				digit = 4
				break
			case '5':
				digit = 5
				break
			case '6':
				digit = 6
				break
			case '7':
				digit = 7
				break
			case '8':
				digit = 8
				break
			case '9':
				digit = 9
				break
			case 'a':
				digit = 10
				break
			case 'b':
				digit = 11
				break
			case 'c':
				digit = 12
				break
			case 'd':
				digit = 13
				break
			case 'e':
				digit = 14
				break
			case 'f':
				digit = 15
				break
			default:
				println "Warning: '" + hex.charAt(i) + "' is not a valid hexadecimal digit; ignoring remaining input"
				error = true
				continue
		}
		result *= 16
		result += digit
	}
	return result
}


String showHex(int i) {
	if (i == 0) {
		return "0"
	}

	String result = ""
	while (i > 0) {
		String digit
		switch (i % 16) {
			case 0:
				digit = "0"
				break
			case 1:
				digit = "1"
				break
			case 2:
				digit = "2"
				break
			case 3:
				digit = "3"
				break
			case 4:
				digit = "4"
				break
			case 5:
				digit = "5"
				break
			case 6:
				digit = "6"
				break
			case 7:
				digit = "7"
				break
			case 8:
				digit = "8"
				break
			case 9:
				digit = "9"
				break
			case 10:
				digit = "a"
				break
			case 11:
				digit = "b"
				break
			case 12:
				digit = "c"
				break
			case 13:
				digit = "d"
				break
			case 14:
				digit = "e"
				break
			case 15:
				digit = "f"
				break
		}
		result = digit + result
		i /= 16
	}

	return result
}

print "Enter a number (decimal or hexadecimal): "
String input = System.console().readLine()

if (verifyHex(input)) {
	println parseHex(input.substring(2))	
} else if (verifyDecimal(input)) {
	println "0x" + showHex(Integer.parseInt(input))
} else {
	println "'" + input + "' is not a valid decimal or hexadecimal number"
}