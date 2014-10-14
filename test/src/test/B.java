package test;

public class B extends A {
	int k;

	public B(int a) {
		super(a);
        k=a+10;
	}
    
	public void sample() {
		System.out.println("the value of k iis " + k);
		//super
		super.sample();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      B b = new B(10);
      b.sample();
	}

}
