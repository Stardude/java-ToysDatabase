package com.lp.oop.model;

public abstract class Toy{
	private String name;
	private double price;
	private int fromAge;
	private int toAge;
	
	private static int numberOfToys = 0;
	
	public Toy()
	{
		numberOfToys++;
	}
	
	public static int getNumberOfToys()
	{
		return numberOfToys;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFromAge() {
		return fromAge;
	}
	public void setFromAge(int fromAge) {
		this.fromAge = fromAge;
	}
	public int getToAge() {
		return toAge;
	}
	public void setToAge(int toAge) {
		this.toAge = toAge;
	}
}
