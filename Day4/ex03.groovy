/*

Create a program in which you define the following methods:
power(int, int): Takes a base b and an exponent e from the user, and returns the result of b^e.
power2(int): Takes an exponent e from the user and returns the result of 2^e. This method must call the previous
one to find out the result.
binary2decimal(String): Takes from the user a binary number (with digits 0 and 1) and returns the corresponding
number in decimal (base-10, with digits between 0 and 9). Hint: in the same way that you know that
35 = 3 · 10^1 + 5 · 10^0, you can find that 100011 = 1 · 2^5 + 1 · 2^1 + 1 · 2^0. This method must call the previous
one to find out the result.
decimal2binary(int): The opposite of the previous one: takes a decimal number and returns the corresponding
binary number. Hint: instead of multiplying by 2, you will need to divide by two this time (the quotients and
the last remainder will give you the binary number).
The program must offer a menu to the user with two options. The first one takes a binary number from the
user and returns the corresponding decimal number. The second one does the opposite: takes a decimal number
and returns a binary number. The program should use the methods defined.*/

int power(int b, int e) {
	if (e == 0) {
		return 1
	} else {
		int result = b
		for (; e > 1; e--) {
			result *= b
		}
		return result
	}
}

int power2(int e) {
	return power(2, e)
}


int binary2decimal(String binary) {
	int result = 0
	for (int i = 0; i < binary.size(); i++) {
		if (binary.charAt(i) == '1') {
			result += power2(binary.size() - i - 1)
		}
	}

	return result
}

String decimal2binary(int decimal) {
	String result = ""
	boolean finished = false
	while (decimal > 0) {
		int bit = decimal % 2
		decimal /= 2
		result = bit + result
	}

	return result
}

enum Choice {
	BINARY_TO_DECIMAL,
	DECIMAL_TO_BINARY
};

Choice choice
boolean choosen = false

println "Choose an option"

while (!choosen) {
	println "1. Binary to decimal"
	println "2. Decimal to binary"
	
	String str = System.console().readLine()
	choosen = true
	if (str == "1") {
		choice = Choice.BINARY_TO_DECIMAL
	} else if (str == "2") {
		choice = Choice.DECIMAL_TO_BINARY
	} else {
		println "Please enter one of the listed options"
		choosen = false
	}
}

switch (choice) {
	case Choice.BINARY_TO_DECIMAL:
		print "Enter a binary number: "
		String input = System.console().readLine()
		println binary2decimal(input)
		break
	case Choice.DECIMAL_TO_BINARY:
		print "Enter a decimal number: "
		int input = Integer.parseInt(System.console().readLine())
		println decimal2binary(input)
		break
}


