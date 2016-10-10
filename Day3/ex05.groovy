/*
Write a program that reads the X and Y coordinates of two points and then outputs the area of a rectangle where
both points are opposite corners.
*/

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

double width = Math.abs(r.bottomRight.x - r.topLeft.x)
double height = Math.abs(r.bottomRight.y - r.topLeft.y)

println "Permeter: " + ((width + height) * 2)
println "Area: " + (width * height)
