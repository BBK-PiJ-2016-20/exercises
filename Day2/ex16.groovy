int scorePlayer1 = 0
int scorePlayer2 = 0

while (Math.abs(scorePlayer1 - scorePlayer2) <= 3) {
	print "Move: "
	String move = System.console().readLine()

	movePlayer1 = move.substring(0, 1)
	movePlayer2 = move.substring(1, 2)
	
	if (movePlayer1 == "R") {
		if (movePlayer2 == "P") {
			println "Paper wraps rock"
			scorePlayer2++
		} else if (movePlayer2 == "S") {
			println "Rock blunts scissors"
			scorePlayer1++
		}
	} else if (movePlayer1 == "P") {
		if (movePlayer2 == "S") {
			println "Scissors cut paper"
			scorePlayer2++
		} else if (movePlayer2 == "R") {
			println "Paper wraps rock"
			scorePlayer1++
		}
	} else if (movePlayer1 == "S") {
		if (movePlayer2 == "R") {
			println "Rock blunts scissors"
			scorePlayer2++
		} else if (movePlayer2 == "P") {
			println "Scissors cut paper"
			scorePlayer1++
		}
	}

	println "Player 1: " + scorePlayer1 + "  Player 2: " + scorePlayer2
}