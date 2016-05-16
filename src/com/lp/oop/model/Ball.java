package com.lp.oop.model;

public class Ball extends Toy {
	private double weight;
	
	public Ball(String name, double price, int fromAge, int toAge, double weight)
	{
		setName(name); setPrice(price); setFromAge(fromAge); setToAge(toAge); setWeight(weight);
	}

	public Ball(){}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
