// Modify the program that you wrote for the former exercise so that it writes on screen the first 1,000 primes.

def primes = []
def primesFound = 0

for (int potentialPrime = 2; primesFound < 1000; potentialPrime++ ) {
	boolean isPrime = true
	for (prime in primes) {
		if (potentialPrime % prime == 0) {
			isPrime = false;
		}
	}
	if (isPrime) {
		primesFound++
		primes.push(potentialPrime)
		println potentialPrime
	}
}