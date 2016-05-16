package com.lp.oop.model;

public class Barby extends Toy {
	private float size;
	
	public Barby(String name, double price, int fromAge, int toAge, float size)
	{
		setName(name); setPrice(price); setFromAge(fromAge); setToAge(toAge); setSize(size);
	}
	
	public Barby(){}
	
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
}
