package practise.inheritence;

public class Test {

	public static void main(String[] args) {
		A a = new B();
		B b = new B();
		//a.bSpecial();  error
		a.showClass();
		b.showClass();
		b.bSpecial();
	}

}
