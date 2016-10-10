/*
Write a program that reads an integer number from the user, and then outputs the 
closest prime number. If there are two prime numbers at the same distance, it 
should output both. For instance, if the user enters 5116, the output should be 
5113 and 5119.
*/

print "Enter a number: "
int target = Integer.parseInt(System.console().readLine())

List primes = []

int potentialPrime = 2
int distance = target
boolean finished = false

while (!finished) {
	boolean isPrime = true
	for (prime in primes) {
		if (potentialPrime % prime == 0) {
			isPrime = false;
		}
	}
	if (isPrime) {
		int newDistance = Math.abs(target - potentialPrime)
		
		// As potentialPrime gets larger, it will get closer to the target, until
		// it reaches the target. Hence, once the distance stops decreasing, we
		// know we have found the answer(s), and so can set finished to true.
		if (newDistance >= distance) {
		  println primes.last()
		  finished = true
		}
		if (newDistance == distance) {
		  println potentialPrime
	  }
	  distance = newDistance
		primes.push(potentialPrime)
	}
	potentialPrime++
}
