package com.masai;

class A<T> {
	T value;

	public A(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
}

public class Demo {
	public static void main(String[] args) {
		A a = new A(20.20);
		A a1 = new A(20);
		System.out.println(a.getValue());
	}
}
