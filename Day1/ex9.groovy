println "Input a sequence of positive numbers (-1 to end)"

int last = Integer.parseInt(System.console().readLine())

boolean finished = last == -1
boolean consecutive = true

while (!finished) {
	int number = Integer.parseInt(System.console().readLine())
	if (number == -1) {
		finished = true
	} else if (number - last != 1) {
		consecutive = false
	}
	last = number
}

if (consecutive) {
	println "Yes"
} else {
	println "No"
}