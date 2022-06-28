package net.model;

public class Xy {
	private int idxy; 
	private float x; 
	private float y;
	private String distination;
	private Seance idseance; 
	
	public Seance getIdseance() {
		return idseance;
	}
	public void setIdseance(Seance idseance) {
		this.idseance = idseance;
	}
	public String getDistination() {
		return distination;
	}
	public void setDistination(String distination) {
		this.distination = distination;
	}
	public int getIdxy() {
		return idxy;
	}
	public void setIdxy(int idxy) {
		this.idxy = idxy;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	

}
