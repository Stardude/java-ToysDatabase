package com.lp.oop.model;

public class Squares extends Toy{
	private int countOfSquares;
	
	public Squares(String name, double price, int fromAge, int toAge, int countOfSquares)
	{
		setName(name); setPrice(price); setFromAge(fromAge); setToAge(toAge); setCount(countOfSquares);
	}

	public Squares(){}

	public int getCount() {
		return countOfSquares;
	}
	public void setCount(int countOfSquares) {
		this.countOfSquares = countOfSquares;
	}
}
