package practise.initial;



public class Test1 {
	int a=10;

	public static  class X {
		int f1() {
			System.out.println("in x f1");
			return 3*f3();
		}
		int f2() {
			System.out.println("in x f2");
			return 4;
		
		}
		int f3() {
			System.out.println("i am in f3 x");
			return 2;
		}
		}
	public static class Y extends X {
		int f1() {
			System.out.println("in y f1");
			return 2*f2();
		}
		int f2() {
			System.out.println("in Y f2");
			return super.f1();}		}
		int f3() {
			return 9;
		}
	public void fun1(){
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		// Construct child and assign to base ptr
		Y obj=new Y() ;
		
		//System.out.println(obj.a);
		//gives error
		//System.out.println(obj.f3());
		System.out.println(obj.f1());
	}
}
