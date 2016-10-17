println "Input a sequence of positive numbers (-1 to end)"

boolean finished = false
int highest = 0

while (!finished) {
	int number = Integer.parseInt(System.console().readLine())
	if (number == -1) {
		finished = true;
	} else if (number > highest) {
		highest = number
	}
}

println "Highest number is: " + highest