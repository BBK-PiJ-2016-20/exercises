// Look at the following code. What does it do? What will it print on the screen?
double d1 = 1.255
double d2 = d1 + 7 - 4 - 3

if (Math.abs(d1 - d2) < 1e-6) {
	println("1.255(" + d1 + ") is equal (to within 1e-6) to 1.255 plus 7 minus 7 (" + d2 + ")");
} else {
	println("1.255(" + d1 + ") is NOT equal (to within 1e-6) to 1.255 plus 7 minus 7 (" + d2 + ")");
}