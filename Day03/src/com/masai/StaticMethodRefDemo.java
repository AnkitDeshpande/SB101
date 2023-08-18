package com.masai;


//suppose this code was written in 2012.
class ArrayOperations{
	static int getMin(int arr[]) {
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}
}


//interface StringToInt(String s) {
//	int convert(String st);
//}

//and we want same implementation today. then why write code again. just refer to pervious code.
@FunctionalInterface
interface ArrayOp{
	int getMinEle(int arr[]);
}

public class StaticMethodRefDemo {
	public static void main(String[] args) {
		ArrayOp ao = ArrayOperations::getMin; //
		System.out.println(ao.getMinEle(new int[] {10, 2, 30, 15, 36, 1, 45}));
		
//		StringToInt sti = Integer::parseInt;
//		System.out.println(sti.convert("45")+1);
	}
}
