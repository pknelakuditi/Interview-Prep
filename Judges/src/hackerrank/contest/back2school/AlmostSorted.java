package hackerrank.contest.back2school;
import java.util.Scanner;

public class AlmostSorted {

   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextDouble();
		}
		almostSorted(a, n);
		sc.close();
	}

	public static boolean almostSorted(double[] a, int n) {
        int flag=0;
     //   double temp=a[0];
        if(a[0]>a[1]){flag++;}
        	for (int i = 1; i < n-1 ; i++) {
                if(a[i]>a[i-1] && a[i]>a[i+1]){flag++;}
            }
     //   if(a[n-1]>a[n-2]){flag++;}
        
        if (flag>2){
            System.out.println("no");
		return false;            
        }
		//double[] a1 = new double[n];
		if (isSorted(a)) {
			   System.out.println("yes");
			   return true;
			} 
		int f1 = 0, f2 = 0;
	//	double temp = a[0];
		for (int i = 0; i < n - 1; i++) {
			if(a[i]<a[i+1]){
				continue;
			}
			for (int k = i + 1; k < n; k++) {
                if(a[i]<a[k] && k<n-2){k++;}
				swap(i, k, a);
				if (isSorted(a)) {
					f1 = i;
					f2 = k;
					System.out.println("yes");
					System.out.print("swap ");
					System.out.print(f1 + 1);
					System.out.print(" ");
					System.out.print(f2 + 1);
					return true;
				} else {
					swap(i, k, a);
					
				}

			}
          if (flag>1){   System.out.println("no");
		return false;            
        }
            for (int k = i + 1; k < n; k++){
               // int x1=k;
                while(k<n-1 && a[k]>a[k+1]){
                    k++;                    
                }
                
                reverse(i, k, a);
					if (isSorted(a)) {
						f1 = i;
						f2 = k;
						System.out.println("yes");
						System.out.print("reverse ");
						System.out.print(f1 + 1);
						System.out.print(" ");
						System.out.print(f2 + 1);
						return true;
					}else{
                        double[] ar = new double[k+1-i];
                        for(int x=0;x<=k-i;x++){
                         ar[x]=a[x+i] ;                            
                        }
                        if(!isSorted(ar)){
                            break;
                        }
						reverse(i, k, a);
					}
            }

		}
		System.out.println("no");
		return false;
	}

	private static void reverse(int i, int j, double[] a) {
		//System.out.println(a[i] + " reverse " + a[j]);
		while (i < j) {
			swap(i, j, a);
			j--;
			i++;
		}

	}

	private static void swap(int a, int b, double[] ar) {
		double temp = ar[a];
		ar[a] = ar[b];
		ar[b] = temp;
		// System.out.println(ar[b] + " swap " + ar[a]);
	}

	private static boolean isSorted(double[] a) { // assume is sorted, attempt
													// to
													// prove otherwise
		for (int i = 0; i < a.length - 1; i++) {

			if (a[i] > a[i + 1]) {
				return false;
			}

		}

		return true; // got to the end, must be sorted
	}
}