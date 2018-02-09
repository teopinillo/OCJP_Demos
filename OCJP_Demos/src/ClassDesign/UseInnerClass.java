package ClassDesign;

public class UseInnerClass {

	//When a static nested class is instantiated outside its outer class, you must prefix it with
	//its outer class name:
	public static void main(String[] args) {
		InnerClasses.StaticNested outNested = new InnerClasses.StaticNested();
		
		//you can access static member of static inner class if it is not private
		//prints: 10
		System.out.printf("%d",InnerClasses.StaticNested.innerStaticInt);

	}

}
