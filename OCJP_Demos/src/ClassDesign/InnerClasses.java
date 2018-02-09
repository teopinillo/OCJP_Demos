package ClassDesign;

public class InnerClasses {
	static int outerStaticInt = 10;
	int outerInt = 20;
	InnerClass innerClass = new InnerClass();
	
	//static inner can access only static outer members. static -> static
		static class StaticNested {
			static int innerStaticInt = 10;
			int innerInt = 20;
		}
		
	//Inner Class or Member Class
    /* -- An inner class is an instance member of its outer class. 
     * -- An instance of an inner class shares a special bond with
     *    its outer class and can’t exist without its instance.
     * --- can be defined using any of the four access levels: 
     *     public, protected, default access, and private.
     * --- can’t define non final static variables or methods
     */
	public class InnerClass {
		
	}

	public static void main(String[] args) {
		//When static nested class is instantiated within its
		//outer class, it doesn't need to be prefixed with
		//its outer class name (though it can)
		StaticNested nested1 = new StaticNested();
		InnerClasses.StaticNested nested2 = new InnerClasses.StaticNested();
		//Modify the value of innerStaticInt for all instances of StaticNested
		nested1.innerStaticInt = 99;
		//Modify only the value of innerInstance for nested1
		nested1.innerInt = 999;
		//prints 99:999
		System.out.printf("%d:%d\n",nested1.innerStaticInt,nested1.innerInt);
		//prints 99:20
		System.out.printf("%d:%d\n",nested2.innerStaticInt,nested2.innerInt);
		
		
		//------------------------------------------------------------------
		// Inner Class or Memeber Class
		InnerClasses myDemo = new InnerClasses();
		InnerClass innerClass = myDemo.new InnerClass();
		//or
		InnerClass innerClass2 = new InnerClasses().new InnerClass();
	}

}


