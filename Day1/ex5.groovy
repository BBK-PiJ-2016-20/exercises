print "Enter a number: "
int first = Integer.parseInt(System.console().readLine())

print "Enter another number: "
int second = Integer.parseInt(System.console().readLine())

boolean negate = false

if (first < 0) {
	negate = true
	first = -first
}

int times = 0
int result = 0

while (times < first) {
	result = result + second
	times++
}

if (negate) {
	first = -first
	result = -result
}

println first + " times " + second + " is " + result