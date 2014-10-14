package practise.initial;

class ModifierCheck{
	public int a1;
	private int a2;
    ModifierCheck(int a,int b){
		a1=a;
		a2=b;
		}
    
    
	public int getA1() {
		return a1;
	}


	public void setA1(int a1) {
		this.a1 = a1;
	}


	public int getA2() {
		return a2;
	}


	public void setA2(int a2) {
		this.a2 = a2;
	}


	public void pu(){
			System.out.println(a2);
			System.out.println("a2 value unchanged");
			System.out.println("I am in Class A public method");
			pr();
			}
	private void pr(){
			System.out.println("I am in Class A private method");
			a2=50;
			System.out.println("a2 value changed which is private");
			}
	protected void prt(){
			System.out.println("I am in Class A protected method");
			}
	void de(){
			System.out.println("I am in Class A default method");
			}
		
	}