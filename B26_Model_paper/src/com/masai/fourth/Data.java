package com.masai.fourth;

public class Data {
	private int intVar;
	private float floatVar;
	private String stringVar;

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

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
