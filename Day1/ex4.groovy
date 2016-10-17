print "Enter a number: "
int n = Integer.parseInt(System.console().readLine())

boolean prime = true;

if (n < 2) {
	prime = false
} else {

	int candidate = 2
	while (candidate <= (n / 2)) {
		if (n % candidate == 0) {
			prime = false;
			println n + " is divisible by " + candidate
			break;
		}
		candidate++
	}
}	

if (prime) {
	println n + " is prime."
} else {
	println n + " is not prime."
}



