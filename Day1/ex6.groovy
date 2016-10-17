print "Enter a number: "
int first = Integer.parseInt(System.console().readLine())

print "Enter another number: "
int second = Integer.parseInt(System.console().readLine())

int times = 0 
int remainder = first

while (remainder >= second) {
	times++
	remainder = remainder - second
}

println first + " divided by " + second + " is " + times + " with remainder " + remainder