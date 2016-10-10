/*
Read five cards from the user. For each card, read the rank (1,2,3,4,5,6,7,8,9, 
10,J,Q,K) and the suit (”spades”, ”hearts”, ”diamonds”, ”clubs”). Each of the 
five cards must be valid before accepting the next one. Once the program has the
five cards, it should tell the user what is the best hand she has got, as per 
the following list (from best to worst):

Straigh flush: all cards are of the same suite and their ranks are consecutive. 
  Note that they are probably not ordered as they were entered.
Poker: four of the five cards have the same rank.
Full House: three of a kind plus two of a kind.
Flush: all cards share the same suit, but are not consecutive.
Straight: all cards are consecutive, but not of the same suit.
Three of a kind: three of the five cards have the same rank.
Two pairs: two pairs (see below).
Pair: two of the five cards have the same rank.
Nothing: any other situation.

*/

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
	}

	i++
}


// Check for flush

boolean flush = true
for (i = 0; i < 4; i++) {
	if (suits[i] != suits[i+1]) {
		flush = false
		break
	}
}

// Count how many cards have each of the 13 possible ranks

int[] cardsWithRank = new int[13]

for (i = 0; i < 5; i++) {
  // The first element of the array is 0, so the array element corresponding
  // to rank 1 is 0, etc, and we need to subtract 1 here.
  cardsWithRank[ranks[i] - 1]++
}

// Loop through all the ranks and check for the different hands

boolean straight = false
int run = 0

boolean poker = false
boolean threeOfAKind = false
int pairs = 0

for (i = 0; i < 13; i++) {
  switch (cardsWithRank[i]) {
    case 0:
      run = 0
      break
    case 1:
      run++
      break
    case 2:
      pairs++
      break
    case 3:
      threeOfAKind = true
      break
    case 4:
      poker = true
      break
  }
  
  if (run == 5) {
    straight = true
    break
  }
}

// Check for the special case of a 10-J-Q-K-A straight. According to Wikipedia, 
// this is only allowed in some games, called "high rule" games.
if (cardsWithRank[9] == 1 && 
    cardsWithRank[10] == 1 && 
    cardsWithRank[11] == 1 &&
    cardsWithRank[12] == 1&&
    cardsWithRank[0] == 1) {
  straight = true
}

if (straight && flush) {
	println "Straight flush"
} else if (poker) {
	println "Poker"
} else if (threeOfAKind && pairs == 1) {
	println "Full house"
} else if (flush) {
	println "Flush"
} else if (straight) {
	println "Straight"
} else if (threeOfAKind) {
	println "Three of a kind"
} else if (pairs == 2) {
	println "Two pairs"
} else if (pairs == 1) {
	println "Pair"
} else {
	println "Nothing"
}

