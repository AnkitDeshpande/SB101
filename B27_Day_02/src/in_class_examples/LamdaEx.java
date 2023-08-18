package in_class_examples;

@FunctionalInterface
interface SquareGenerator{
	int makeSquare(int number);
}

@FunctionalInterface
interface AddNumber{
	int sum(int a, int b);
}


interface WelcomeMsg{
	String welcome();
}


public class LamdaEx {
	public static void main(String[] args) {
		
		SquareGenerator s1 = num ->num*num;
		System.out.println(s1.makeSquare(13));
		
		AddNumber a1 =  (n,m) -> n+m;
		System.out.println(a1.sum(10, 90));
		
		WelcomeMsg w1 = () ->"Welcome Ankit";
		System.out.println(w1.welcome());
		
	}
}
