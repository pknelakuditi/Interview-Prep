package ctci.arraysAndStrings;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableDemo {

	public static void main(String args[]) {
	
		Hashtable<String,Student> record = new Hashtable();
		Enumeration names;
		String str;
		// sub= new String[3];
		 String[] sub={"DOS","CN","ADS"};
		record.put("pavan", new Student("pavan",2015,sub));
		sub[2]="Algos";
		record.put("varun", new Student("varun",2018,sub));
	//	record.put("varun", new Student("varun",2013,Array("DOS","CN","ADS")));
		
		names= record.keys();
		while(names.hasMoreElements()){
			str=(String) names.nextElement();
		   System.out.println(str);
//		   Student s=record.get(str);
//		   System.out.println(s.year);
		   System.out.println(record.get(str).year);
		}
		
			
		ArrayList<String> sentence=new ArrayList<String>();
		for(String s: sub){sentence.add(s);}
		
		
		
	}
	
	static class Student{
		String name;
		int year;
		String[] subjects;
		public Student(String name, int year, String[] subjects) {
			super();
			this.name = name;
			this.year = year;
			this.subjects = subjects;
		}
		
		
	}
//    class University{
//    	ArrayList<Student> studentRecord;
//
//		public ArrayList<Student> getStudentRecord() {
//			return studentRecord;
//		}
//
//		public void setStudentRecord(ArrayList<Student> studentRecord) {
//			this.studentRecord = studentRecord;
//		}
//    }	
}
