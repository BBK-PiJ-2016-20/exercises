boolean tryagain = true;

while (tryagain) {
	println "Please choose an option:"
	println "For 'Checking your balance', please enter 1"
	println "For 'Purchases', please enter 2"
	println "For 'Refunds', please enter 3"
	println "For 'Queries about the warranty', please enter 4"
	println "For 'Returning faulty goods', please enter 5"
	println "For any other query, please enter 0"
	String s = System.console().readLine()
	Integer choice = Integer.parseInt(s)


	tryagain = false;
	switch (choice) {
	case 1:
		println "Checking balance..."
		break;
	case 2:
		println "Listing purchases..."
		break;
	case 3:
		println "Processing refunds..."
		break;
	case 4:
		println "Answering queries..."
		break;
	case 5:
		println "Returning faulty goods..."
		break;
	default:
		println "Unrecognised option, try again."
		tryagain = true;	
	}
}