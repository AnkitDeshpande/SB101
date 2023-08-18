package com.masai.Question1;

import java.util.ArrayList;
import java.util.List;

interface calculate {
	void computeBMI(List<Human> humanList);

	void printRemark(List<Human> humanList);
}

public class PartC {
	public static void main(String[] args) {
		List<Human> humans = new ArrayList<>();

		Human human1 = new Human(65, 1.7);
		Human human2 = new Human(75, 1.6);
		Human human3 = new Human(45, 1.4);
		Human human4 = new Human(45, 1.7);
		Human human5 = new Human(48, 1.2);
		Human human6 = new Human(92, 1.6);
		Human human7 = new Human(116, 1.65);
		Human human8 = new Human(55, 1.75);
		Human human9 = new Human(63, 1.68);
		Human human10 = new Human(80, 1.85);

		humans.add(human1);
		humans.add(human2);
		humans.add(human3);
		humans.add(human4);
		humans.add(human5);
		humans.add(human6);
		humans.add(human7);
		humans.add(human8);
		humans.add(human9);
		humans.add(human10);

		calculate c1 = new calculate() {

			@Override
			public void printRemark(List<Human> humanList) {
				// TODO Auto-generated method stub
				for (Human h : humanList) {
					if (h.getBodyMassIndex() < 18.5) {
						System.out.println("Underweight, your BMI is : " + h.getBodyMassIndex());
					} else if (h.getBodyMassIndex() >= 18.5 && h.getBodyMassIndex() < 25.0) {
						System.out.println("Normal, your BMI is : " + h.getBodyMassIndex());
					} else if (h.getBodyMassIndex() >= 25.0 && h.getBodyMassIndex() < 30.0) {
						System.out.println("Overweight, your BMI is : " + h.getBodyMassIndex());
					} else if (h.getBodyMassIndex() >= 30.0 && h.getBodyMassIndex() < 35.0) {
						System.out.println("Obese, your BMI is : " + h.getBodyMassIndex());
					} else {
						System.out.println("Extreme Obese, your BMI is : " + h.getBodyMassIndex());
					}
				}
			}

			@Override
			public void computeBMI(List<Human> humanList) {
				// TODO Auto-generated method stub

				for (Human h : humanList) {
					double bmi = h.getWieght() / (h.getHeight() * h.getHeight());
					bmi = Math.round(bmi * 10 / 10.0);
					h.setBodyMassIndex(bmi);
					System.out.println(h);
				}
			}
		};

		c1.computeBMI(humans);
		System.out.println();
		c1.printRemark(humans);
	}
}
