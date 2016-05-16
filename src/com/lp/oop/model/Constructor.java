package com.lp.oop.model;

public class Constructor extends Toy {
	private int numberOfConstructs;
	
	public Constructor(String name, double price, int fromAge, int toAge, int numberOfConstructs)
	{
		setName(name); setPrice(price); setFromAge(fromAge); setToAge(toAge); setNumberOfConstructs(numberOfConstructs);
	}

	public Constructor(){}
	
	public int getNumberOfConstructs() {
		return numberOfConstructs;
	}
	public void setNumberOfConstructs(int numberOfConstructs) {
		this.numberOfConstructs = numberOfConstructs;
	}
}
