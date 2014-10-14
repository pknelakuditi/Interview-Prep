package practise.initial;

public class InheritClass implements Inherit{

	public static void main(String[] args) {
		InheritClass a = new InheritClass();
		a.fun();
		a.fun1();
		System.out.println(InheritClass.in);
	//	InheritClass.in=21;
	}

	@Override
	public void fun() {
		System.out.println("implementation of fun");
	}

	@Override
	public void fun1() {
		System.out.println("omplentation of fun1");
	}

}
