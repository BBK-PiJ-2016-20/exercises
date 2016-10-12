/*
Write a program in which you create and use a class called Point, with two fields of type double (e.g. x, y) and the
following methods:
distanceTo(Point): calculates the distance to another point.
distanceToOrigin(): calculates the distance to the origin. Implement it by calling the first method.
moveTo(double x, double y): changes the coordinates of this point to be the given parameters x and y.
moveTo(Point): changes the coordinates of this point to move where the given point is.
clone(): returns a copy of the current point with the same coordinates.
opposite(): returns a copy of the current point with the coordinates multiplied by -1.
*/

class Point {
	double x
	double y
	
	Point(double x, double y) {
		this.x = x
		this.y = y
	}

	double distanceTo(Point other) {
		return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2))
	}

	double distanceToOrigin() {
		return distanceTo(new Point(0, 0))
	}

	void moveTo(double x, double y) {
		this.x = x
		this.y = y
	}

	void moveTo(Point other) {
		x = other.x
		y = other.y
	}

	Point clone() {
		return new Point(x, y)
	}

	Point opposite() {
		return new Point(-x, -y)
	}
}


Point p = new Point(10, 20)

println "Distance to origin: " + p.distanceToOrigin()

Point p2 = p.clone()

p2.moveTo(30, 40)

println "Distance of old and new point: " + p.distanceTo(p2)

println "Distance of new point and its opposite: " + p2.distanceTo(p2.opposite())

