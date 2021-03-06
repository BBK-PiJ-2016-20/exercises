/*
Write a program that reads the total cost of a purchase and an amount of money that is paid to buy it. Your
program should output the correct change specifying the amount of notes (50, 20, 10, 5) and coins (2, 1, 0.50, 0.20,
0.10, 0.05, 0.02, 0.01) needed.
*/
boolean entered = false

double cost
double paid
while (!entered) {
	print "Enter cost: "
	cost = Double.parseDouble(System.console().readLine())

	print "Enter amount paid: "
	paid = Double.parseDouble(System.console().readLine())

	if (paid < cost) {
		println "The amount paid cannot be less than the cost"
	} else {
		entered = true
	}
}

// Calculate the change in whole pence, so that all rounding happens here
int changeRemaining = paid * 100 - cost * 100

List denominations = [5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1]

for (int denomination in denominations) {
	int use = changeRemaining / denomination
	changeRemaining = changeRemaining % denomination
	if (use > 0) {
		if (denomination >= 500) {
			println use + " * �" + (denomination / 100) + " notes"
		} else {
			println use + " * " + denomination + "p coins"
		}
	}
}