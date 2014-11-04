





public class test {
	public static void main(String args[]){
		System.out.println(check("(618-513-7704adsafa"));
		System.out.println(checkName("Nelakuditi pavan Kumar"));
	}

	private static String checkName(String string) {
		
		return null;
	}

	public static String check(String pn){
		int i=0;
		StringBuilder sb=new StringBuilder();
		while(i<pn.length()){
			int temp=pn.charAt(i);
		//	System.out.println(temp);
			if(temp<=58 && temp>=48){
				sb.append(pn.charAt(i));
			}
			i++;
		
		}
System.out.println(sb.toString());
			if(sb.length()==10){
				return sb.toString();
			}else{
				return "Invalid";
			}
	}

}
