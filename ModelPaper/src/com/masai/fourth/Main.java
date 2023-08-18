package com.masai.fourth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Data {
	private int intVar;
	private float floatVar;
	private String stringVar;

	public Data(int intVar, float floatVar, String stringVar) {
		super();
		this.intVar = intVar;
		this.floatVar = floatVar;
		this.stringVar = stringVar;
	}

	public int getIntVar() {
		return intVar;
	}

	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}

	public float getFloatVar() {
		return floatVar;
	}

	public void setFloatVar(float floatVar) {
		this.floatVar = floatVar;
	}

	public String getStringVar() {
		return stringVar;
	}

	public void setStringVar(String stringVar) {
		this.stringVar = stringVar;
	}

	@Override
	public String toString() {
		return "Data [intVar=" + intVar + ", floatVar=" + floatVar + ", stringVar=" + stringVar + "]";
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Data> ls = new ArrayList<>();
		ls.add(new Data(1, 10.0f, "First"));
		ls.add(new Data(4, 40.0f, "Fourth"));
		ls.add(new Data(2, 20.0f, "Second"));
		ls.add(new Data(3, 30.0f, "Third"));
		ls.add(new Data(5, 50.0f, "Fifth"));
		ls.add(new Data(8, 80.0f, "Eight"));
		ls.add(new Data(10, 100.0f, "Tenth"));
		ls.add(new Data(6, 60.0f, "sixth"));
		ls.add(new Data(7, 70.0f, "Seventh"));
		ls.add(new Data(9, 90.0f, "Ninth"));

		ls.stream().sorted(Comparator.comparingDouble(d -> d.getFloatVar())).distinct().skip(1)
				.limit(6).collect(Collectors.toList()).forEach(x->System.out.print(x+"\n"));

		
		
		
		int sum = ls.stream().mapToInt(i->i.getIntVar()).reduce(0, Integer::sum);
		System.out.println("Sum of intVar for all elements: " + sum);
	}

}
