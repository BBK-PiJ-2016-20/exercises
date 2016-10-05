println "Try to guess my number"

int secretNumber = Math.abs(1000 * Math.random())
boolean guessed = false
int guesses = 0

while (!guessed) {
	print "Guess a number: "
	int guess = Integer.parseInt(System.console().readLine())
	guesses++
	if (guess < secretNumber) {
		println "No! My number is higher"
	} else if (guess > secretNumber) {
		println "No! My number is lower"
	} else {
		guessed = true
	}
}

println "CORRECT"
println "You needed " + guesses + " guesses."