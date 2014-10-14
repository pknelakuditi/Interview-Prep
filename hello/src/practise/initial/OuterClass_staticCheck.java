/**
 * 
 */
package practise.initial;

/**
 * @author pavan
 *
 */
class OuterClass_staticCheck {
	class Nestedclass{
		public int y=0;
	    private void fun1(){System.out.println("I am in nested class private method");}	
	}
	
	static class StaticNested{public static int x=10;
		}
public void fun(){ Nestedclass nest = new Nestedclass();
 	nest.fun1();

	}

}
