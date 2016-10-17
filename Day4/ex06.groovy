class Integer2 {
    int value;

    int getValue() {
        return value;
    }

    int setValue(int i) {
        value = i;
    }

    boolean isEven() {
        return value % 2 == 0;
    }

    boolean isOdd() {
        return !isEven();
    }

    void prettyPrint() {
        print(value);
    }

    String toString() {
        String ret = "";
        int rest = value;
        boolean negative = false;

        if (rest == 0) {
            return "0";
        } else if (rest < 0) {
            negative = true;
            rest = -rest;
        }

        while (rest > 0) {
            int digit = rest % 10;
            rest /= 10;
            switch (digit) {
                case 0:
                    ret = "0" + ret;
                    break;
                case 1:
                    ret = "1" + ret;
                    break;
                case 2:
                    ret = "2" + ret;
                    break;
                case 3:
                    ret = "3" + ret;
                    break;
                case 4:
                    ret = "4" + ret;
                    break;
                case 5:
                    ret = "5" + ret;
                    break;
                case 6:
                    ret = "6" + ret;
                    break;
                case 7:
                    ret = "7" + ret;
                    break;
                case 8:
                    ret = "8" + ret;
                    break;
                case 9:
                    ret = "9" + ret;
                    break;
            }
        }

        if (negative) {
            return "-" + ret;
        } else {
            return ret;
        }
    }
}

Integer2 i2 = new Integer2();
print "Enter a number: ";
String str = System.console().readLine();
int i = Integer.parseInt(str);
i2.setValue(i);
print "The number you entered is "
if (i2.isEven()) {
    println "even.";
} else if (i2.isOdd()) {
    println "odd.";
} else {
    println "undefined!! Your code is buggy!";
}

int parsedInt = Integer.parseInt(i2.toString());

if (parsedInt == i2.getValue()) {
    println("Your toString() method seems to work fine.");
}