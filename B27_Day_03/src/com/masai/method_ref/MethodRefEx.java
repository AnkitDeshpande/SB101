package com.masai.method_ref;

import java.util.Arrays;

class ArrayOps {
	static int getMin(int arr[]) {
		int min = arr[0];
		for (int ar : arr) {
			if (min > ar) {
				min = ar;
			}
		}
		return min;
	}
}

interface ArrOps {
	int getMinFromArray(int arr[]);
}

interface StringToInt{
	int getInt(String str);
}

interface IsArrayEqual{
	boolean check(int arr[], int arr2[]);
}

public class MethodRefEx {
	public static void main(String[] args) {
		ArrOps a1 = ArrayOps::getMin;
		int arr [] = {1,269,53,-5};
		int min = a1.getMinFromArray(arr);
		System.out.println(min);
		System.out.println();
		
		StringToInt s1 = Integer::parseInt;
		System.out.println(s1.getInt("10"));
		System.out.println();
		
		int arr3[] = {1,2,3};
		int arr2[] = {1,2,3};
		
		IsArrayEqual i1 = Arrays::equals;
		System.out.println(i1.check(arr3, arr2));
	}
}
