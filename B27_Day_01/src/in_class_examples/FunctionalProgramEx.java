package in_class_examples;

@FunctionalInterface
interface intr{
	void sayHello(String name);
}

class impl implements intr{

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("Hello " + name);
	}
	
}

public class FunctionalProgramEx {
	
	public static void main(String[] args) {
		intr i1 = new impl();
		i1.sayHello("Ankit");
		
		intr i2 = new intr() {

			@Override
			public void sayHello(String name) {
				// TODO Auto-generated method stub
				System.out.println("Using anonymous class "+ name);
			}
			
		};
		i2.sayHello("Ankit");
		
		intr i3 = (String name) ->System.out.println("Inside lamda expression " + name);
		
		i3.sayHello("Ankit");
	}

}
