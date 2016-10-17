int[] ranks = new int[5]
String[] suits = new String[5]

int i = 0
while (i < 5) {
	print "Rank: "
	rank = System.console().readLine()
	if (rank == "1") {
		ranks[i] = 1
	} else if (rank == "2") {
		ranks[i] = 2
	} else if (rank == "3") {
		ranks[i] = 3
	} else if (rank == "4") {
		ranks[i] = 4
	} else if (rank == "5") {
		ranks[i] = 5
	} else if (rank == "6") {
		ranks[i] = 6
	} else if (rank == "7") {
		ranks[i] = 7
	} else if (rank == "8") {
		ranks[i] = 8
	} else if (rank == "9") {
		ranks[i] = 9
	} else if (rank == "10") {
		ranks[i] = 10
	} else if (rank == "J") {
		ranks[i] = 11
	} else if (rank == "Q") {
		ranks[i] = 12
	} else if (rank == "K") {
		ranks[i] = 13
	} else {
		println rank + " is not a valid rank. Enter a number from 1 to 10, or J, Q, or K."
		continue
	}
	
	print "Suit: "
	String suit = System.console().readLine()
	if (suit != "hearts" && suit != "clubs" && suit != "diamonds" && suit != "spades") {
		println suit + " is not a valid suit. Enter hearts, clubs, diamonds, or spades."
		continue
	}
	i++
}

