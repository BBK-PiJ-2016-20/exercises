/*
Write a program that reads a number with commas and decimal dots (such as “23,419.34”) and then prints a
number that is half of it. Do not use Double.parseDouble().
*/

print "Enter a number: "
String str = System.console().readLine()

double result = 0
int decimalPlaces = 0
boolean error = false

for (int i = 0; i < str.size(); i++) {
    char c = str.charAt(i)
    if (Character.isDigit(c)) {
        int value
        switch (c) {
            case '0':
                value = 0
                break
            case '1':
                value = 1
                break
            case '2':
                value = 2
                break
            case '3':
                value = 3
                break
            case '4':
                value = 4
                break
            case '5':
                value = 5
                break
            case '6':
                value = 6
                break
            case '7':
                value = 7
                break
            case '8':
                value = 8
                break
            case '9':
                value = 9
                break
        }

        if (decimalPlaces == 0) {
            result *= 10
            result += value
        } else {
            result += value / Math.pow(10, decimalPlaces)
            decimalPlaces++
        }

    } else if (c == '.') {
        if (decimalPlaces > 0) {
            println "Warning: string contains two decimal points; ignoring everything after the second"
            break
        }
        decimalPlaces = 1
    } else if (c == ',') {
        // Commas have no semantic meaning, so ignore them. I could report an error if commas are 
        // used anywhere other than between groups of three characters, but I don't see any value
        // in that; and anyway, I believe outside of Europe commas are used in different places
        // (e.g. between groups of four characters in India).
    } else {        
        println "Warning: string contains an invalid character, '" + c + "'; ignoring everything after it"
        break
    } 
}

println result 
