/*
Write a program that reads the coordinates of four points, the former two defining one rectangle and the latter two
defining another one. The program must read the coordinates of a fifth point and say whether the point is inside
both rectangles, inside one of them only, or out of both.
*/

class Point {
	double x
	double y
}

class Rectangle {
	Point topLeft
	Point bottomRight
}

Rectangle r1 = new Rectangle()

r1.topLeft = new Point()

print "Top left x: "
r1.topLeft.x = Double.parseDouble(System.console().readLine())

print "Top left y: "
r1.topLeft.y = Double.parseDouble(System.console().readLine())

r1.bottomRight = new Point()

print "Bottom right x: "
r1.bottomRight.x  = Double.parseDouble(System.console().readLine())

print "Bottom right y: "
r1.bottomRight.y = Double.parseDouble(System.console().readLine())

if (r1.topLeft.x > r1.bottomRight.x ) {
	println "Warning: value entered for top left is to the right of bottom right, swapping"
	double temp = r1.bottomRight.x
	r1.bottomRight.x = r1.topLeft.x
	r1.topLeft.x = temp
}

if (r1.topLeft.y > r1.bottomRight.y ) {
	println "Warning: value entered for top left is below bottom right, swapping"
	double temp = r1.bottomRight.y
	r1.bottomRight.y = r1.topLeft.y
	r1.topLeft.y = temp
}

Rectangle r2 = new Rectangle()

r2.topLeft = new Point()

print "Top left x: "
r2.topLeft.x = Double.parseDouble(System.console().readLine())

print "Top left y: "
r2.topLeft.y = Double.parseDouble(System.console().readLine())

r2.bottomRight = new Point()

print "Bottom right x: "
r2.bottomRight.x  = Double.parseDouble(System.console().readLine())

print "Bottom right y: "
r2.bottomRight.y = Double.parseDouble(System.console().readLine())

if (r2.topLeft.x > r2.bottomRight.x ) {
	println "Warning: value entered for top left is to the right of bottom right, swapping"
	double temp = r2.bottomRight.x
	r2.bottomRight.x = r2.topLeft.x
	r2.topLeft.x = temp
}

if (r2.topLeft.y > r2.bottomRight.y ) {
	println "Warning: value entered for top left is below bottom right, swapping"
	double temp = r2.bottomRight.y
	r2.bottomRight.y = r2.topLeft.y
	r2.topLeft.y = temp
}


Point toTest = new Point()

print "Point x: "
toTest.x = Double.parseDouble(System.console().readLine())

print "Point y: "
toTest.y = Double.parseDouble(System.console().readLine())

boolean in1 = false

if (toTest.x > r1.topLeft.x && toTest.x < r1.bottomRight.x && toTest.y > r1.topLeft.y && toTest.y < r1.bottomRight.y) {
	in1 = true
} 

boolean in2 = false

if (toTest.x > r2.topLeft.x && toTest.x < r2.bottomRight.x && toTest.y > r2.topLeft.y && toTest.y < r2.bottomRight.y) {
	in2 = true
} 

if (in1 && in2) {
	println "(" + toTest.x + ", " + toTest.y + ") is in both rectangles"
} else if (in1) {
	println "(" + toTest.x + ", " + toTest.y + ") is only in the first rectangle"
} else if (in2) {
	println "(" + toTest.x + ", " + toTest.y + ") is only in the second rectangle"
} else {
	println "(" + toTest.x + ", " + toTest.y + ") is outside both rectangles"
}	