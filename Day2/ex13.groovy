// Write a program that prints all on screen all prime numbers up to 1,000.

def primes = []

for (int potentialPrime = 2; potentialPrime < 1000; potentialPrime++ ) {
	boolean isPrime = true
	for (prime in primes) {
		if (potentialPrime % prime == 0) {
			isPrime = false;
		}
	}
	if (isPrime) {
		primes.push(potentialPrime)
		println potentialPrime
	}
}