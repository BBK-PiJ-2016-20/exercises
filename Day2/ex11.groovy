enum Suit {
	HEARTS,
	CLUBS,
	DIAMONDS,
	SPADES
}

int[] ranks = new int[5]
Suit[] suits = new Suit[5]

println "Enter 5 cards as rank (1-10, J, Q, K) and suit (hearts, clubs, diamonds, spades)"

int i = 0
while (i < 5) {
	boolean rankEntered = false
	while (!rankEntered) {
		print "Rank: "
		rank = System.console().readLine()
		rankEntered = true
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
			rankEntered = false
		}
	}
	
	boolean suitEntered = false;
	while (!suitEntered) {
		print "Suit: "
		String suit = System.console().readLine()
		suitEntered = true
		if (suit == "hearts") {
			suits[i] = Suit.HEARTS
		} else if (suit == "clubs") {
			suits[i] = Suit.CLUBS
		} else if (suit == "diamonds") {
			suits[i] = Suit.DIAMONDS 
		} else if (suit == "spades") {
			suits[i] = Suit.SPADES
		} else {
			println suit + " is not a valid suit. Enter hearts, clubs, diamonds, or spades."
			suitEntered = false
		}
		i++
	}
}


// Check for flush

boolean flush = true
for (i = 0; i < 4; i++) {
	if (suits[i] != suits[i+1]) {
		flush = false
		break
	}
}


// Check for straight (NB this currently does not detect a 10-J-Q-K-A straight, because A is stored as 1)

int minDiff = 5
int maxDiff = 0
for (i = 0; i < 4; i++) {
	for (j = i + 1; j < 5; j++) {
		int diff = ranks[i] - ranks[j]
		if (diff < 0) { 
			diff = -diff 
		}
		if (diff < minDiff) {
			minDiff = diff
		}
		if (diff > maxDiff) {
			maxDiff = diff
		}
	}
}

boolean straight = minDiff == 1 && maxDiff == 4


// Check for number of same suit (poker, three of a kind, pairs)

int[] sameRanks = new int[5]

for (i = 0; i < 5; i++) {
	for (int j = 0; j < 5; j++) {
		if (i == j)
			continue
		if (ranks[i] == ranks[j]) {
			sameRanks[i]++;
		}
	}
}

boolean poker = false 
boolean threeOfAKind = false
int pairedCards = 0 // How many cards are members of a pair (i. e. if there is one pair, pairedCards == 2)

for (i = 0; i < 5; i++) {
	if (sameRanks[i] == 3) {
		poker = true	
	} else if (sameRanks[i] == 2) {
		threeOfAKind = true
	} else if (sameRanks[i] == 1) {
		pairedCards++
	}
}

boolean fullHouse = threeOfAKind && pairedCards == 2
boolean twoPairs = pairedCards == 4
boolean pair = pairedCards == 2

if (straight && flush) {
	println "Straight flush"
} else if (poker) {
	println "Poker"
} else if (fullHouse) {
	println "Full house"
} else if (flush) {
	println "Flush"
} else if (straight) {
	println "Straight"
} else if (threeOfAKind) {
	println "Three of a kind"
} else if (twoPairs) {
	println "Two pairs"
} else if (pair) {
	println "Pair"
} else {
	println "Nothing"
}

