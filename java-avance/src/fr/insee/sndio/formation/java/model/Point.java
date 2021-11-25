package fr.insee.sndio.formation.java.model;

public class Point {
	private double x;
	private double y;

	@Override
	public String toString() {
		return "X : " + x +". Y : " +y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}