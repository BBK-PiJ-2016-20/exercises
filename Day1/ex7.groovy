print "Enter a number: "
int first = Integer.parseInt(System.console().readLine())

print "Enter another number: "
int second = Integer.parseInt(System.console().readLine())

print "Enter a third number: "
int third = Integer.parseInt(System.console().readLine())

int lowest
int middle
int highest

if (first < second) {
	if (third < first) {
		lowest = third
		middle = first
		highest = second
	} else {
		lowest = first
		if (third < second) {
			middle = third
			highest = second
		} else {
			middle = second
			highest = third
		}
	}
} else {
	if (third < second) {
		lowest = third
		middle = second
		highest = first
	} else {
		lowest = second
		if (first < third) {
			middle = first
			highest = third
		} else {
			middle = third
			highest = first
		}
	}
}		

println lowest
println middle
println highest

int minFirstSecond
int maxFirstSecond

if (first < second) {
	minFirstSecond = first
	maxFirstSecond = second
} else {
	minFirstSecond = second
	maxFirstSecond = first
}

if (third < minFirstSecond) {
	lowest = third
	middle = minFirstSecond
} else {
	lowest = minFirstSecond
}

if (third > maxFirstSecond) {
	highest = third
	middle = maxFirstSecond
} else {
	highest = maxFirstSecond
}

if (third > minFirstSecond && third < maxFirstSecond) {
	middle = third
}

println lowest
println middle
println highest
