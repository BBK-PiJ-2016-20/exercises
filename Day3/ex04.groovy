/*
Write a program that reads the X and Y coordinates of three points and then outputs which of the three are closer.
*/


class Point {
	double x
	double y
}


Point a = new Point()
Point b = new Point()
Point c = new Point()

print "x1: "
a.x = Double.parseDouble(System.console().readLine())

print "y1: "
a.y = Double.parseDouble(System.console().readLine())

print "x2: "
b.x = Double.parseDouble(System.console().readLine())

print "y2: "
b.y = Double.parseDouble(System.console().readLine())

print "x3: "
c.x = Double.parseDouble(System.console().readLine())

print "y3: "
c.y = Double.parseDouble(System.console().readLine())

distanceAB = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2))
distanceAC = Math.sqrt(Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2))
distanceBC = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2))

if (distanceAB < distanceAC) {
	if (distanceAB < distanceBC) {
		println "(" + a.x + ", " + a.y + ") and (" + b.x + ", " + b.y + ") are closest"
	} else {
		println "(" + b.x + ", " + b.y + ") and (" + c.x + ", " + c.y + ") are closest"		
	}
} else {
	if (distanceAC < distanceBC) {
		println "(" + a.x + ", " + a.y + ") and (" + c.x + ", " + c.y + ") are closest"		
	} else {
		println "(" + b.x + ", " + b.y + ") and (" + c.x + ", " + c.y + ") are closest"	
	}
}