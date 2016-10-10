/*
Write a program that reads the coordinates of the two points defining a rectangle and then the coordinates of a
third point. The program must then determine whether the point falls inside or outside the rectangle.*/

class Point {
	double x
	double y
}

class Rectangle {
	Point topLeft
	Point bottomRight
}

Rectangle r = new Rectangle()

r.topLeft = new Point()

print "Top left x: "
r.topLeft.x = Double.parseDouble(System.console().readLine())

print "Top left y: "
r.topLeft.y = Double.parseDouble(System.console().readLine())

r.bottomRight = new Point()

print "Bottom right x: "
r.bottomRight.x  = Double.parseDouble(System.console().readLine())

print "Bottom right y: "
r.bottomRight.y = Double.parseDouble(System.console().readLine())

if (r.topLeft.x > r.bottomRight.x ) {
	println "Warning: value entered for top left is to the right of bottom right, swapping"
	double temp = r.bottomRight.x
	r.bottomRight.x = r.topLeft.x
	r.topLeft.x = temp
}

if (r.topLeft.y > r.bottomRight.y ) {
	println "Warning: value entered for top left is below bottom right, swapping"
	double temp = r.bottomRight.y
	r.bottomRight.y = r.topLeft.y
	r.topLeft.y = temp
}


Point toTest = new Point()

print "Third point x: "
toTest.x = Double.parseDouble(System.console().readLine())

print "Third point y: "
toTest.y = Double.parseDouble(System.console().readLine())

if (toTest.x > r.topLeft.x && toTest.x < r.bottomRight.x && toTest.y > r.topLeft.y && toTest.y < r.bottomRight.y) {
	println "(" + toTest.x + ", " + toTest.y + ") is INSIDE the rectangle"
} else {
	println "(" + toTest.x + ", " + toTest.y + ") is OUTSIDE the rectangle"
}