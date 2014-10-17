import java.util.PriorityQueue;
import java.util.Scanner;





public class test {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       Scanner sc = new Scanner(System.in);
    //  System.out.println(sc.nextInt(2));
//    	System.out.println(Math.sqrt(10));
//    	int a=(int) Math.sqrt(10);
//    	System.out.println(a);
	//System.out.println("keka "+pow());	
//  System.out.println(11100|01011);
//       StringTokenizer st=new StringTokenizer(sc.nextLine());
//       int R = Integer.parseInt(st.nextToken());
//       
//       System.out.println(st);
//       System.out.println(R);
//       sc.close();
//       String st="asfdfsf";
//       char a='a';
//       a+=2;
//       System.out.println(a);
//       System.out.println();
//       List<Integer> s = new ArrayList<Integer>();
//       System.out.println(s);
     /*  s.add(1);
       s.add(2);
       while(s.iterator().next()!=null){
    	   System.out.println(s.iterator().next());
       }*/
//       PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
//       pq.add(1);
//       pq.add(2);
//       pq.add(1);
//       System.out.println(pq.toString());
//       System.out.println(pq.remove());
//       System.out.println(pq.remove());
       
    //   long l=1l<<60;
     //  System.out.println(l);
       Abs[] abs =new Abs[5];
       abs[0]=new Abs(10);
       abs[1]=new Abs(5);
       abs[2]=new Abs(-6);
       abs[3]=new Abs(-7);
       abs[4]=new Abs(11);
       PriorityQueue<Abs> pq=new PriorityQueue<Abs>();
      for(Abs e:abs){pq.add(e);}
      System.out.println(pq.remove().a);
      abs[2]=new Abs(55);
      pq.add(abs[2]);
//      Iterator<Abs> i=pq.iterator();
//		while(i.hasNext()){
//			Abs te=i.next();
//			System.out.print(te.a+" ");
//		}
//		System.out.println();
      for(int i1=0;i1<5;i1++){
    	 System.out.println(pq.remove().a);;
      }
    }
    
    
    static class Abs implements Comparable<Abs>{
    	int a;

		public Abs(int a) {
			super();
			this.a = a;
		}

		@Override
		public int compareTo(Abs o) {
			// TODO Auto-generated method stub
			return this.a - o.a;
		}

		
    	
    }
    
	
}
