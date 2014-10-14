package algos.standard.sorting;

import java.util.Arrays;

public class Heap {
	int []unsortedArray;
	public Heap(int[] arr){this.unsortedArray=arr;}
	
	public void buildMaxHeap(){
		
		for (int i=this.unsortedArray.length/2 -1;i>=0;i--)
		{
			maxHeapify(i);
		}
		
		
	}

	private void maxHeapify(int x) {
		 int l,r,max;
		 l=2*(x+1)-1;
		 r=2*(x+1);
		 max=x;
		// System.out.println("max is :"+max);
		// System.out.println("r is: "+r);
		// System.out.println("l is: "+l);

		 if(l<this.unsortedArray.length && this.unsortedArray[l]>this.unsortedArray[max])
		 { max=l;
		   //  System.out.println("max is l: "+l);
		 }

		 if(r<this.unsortedArray.length && this.unsortedArray[r]>this.unsortedArray[max])
			 {max=r;
		   //  System.out.println("max is r: "+r);
			 }

		 if(max!=x){
			 swap(x,max,this.unsortedArray);
			 maxHeapify(max);
		 
		 }
		 
	}
	
	private void swap(int x,int y,int[] arr){
		int z=arr[y];
		arr[y]=arr[x];
		arr[x]=z;
	//	System.out.println(arr[y]+"swapped"+arr[x]);
	}
	
	public void heapSort(){
		int len=this.unsortedArray.length;
		int[] a= new int[this.unsortedArray.length];
		//pre-condition : buildMaxHeap is performed on unsortedArray before 
		for(int i =0;i<len;i++) {
			//System.out.println(this.unsortedArray[0]);
			a[i]=this.unsortedArray[0];
			swap(0,this.unsortedArray.length-1,this.unsortedArray);
			//System.out.println("swap");
			//for(int k=0;k<this.unsortedArray.length;k++){System.out.print(this.unsortedArray[k]);}
			//System.out.println("copy");
			this.unsortedArray=Arrays.copyOfRange(this.unsortedArray,0,this.unsortedArray.length-1);
			//for(int k=0;k<this.unsortedArray.length;k++){System.out.print(this.unsortedArray[k]);}
			//System.out.println();
			maxHeapify(0);
			//System.out.println("heapify");
			//for(int k=0;k<this.unsortedArray.length;k++){System.out.print(this.unsortedArray[k]);}
			//System.out.println();
		}
		for(int i1=0;i1<a.length;i1++){System.out.print(a[i1]);}
	}

	public static void main(String[] args) {
		int[] arr={6,5,3,1,8,7,2,4};
		Heap heap = new Heap(arr);
		heap.buildMaxHeap();
		System.out.println("Array after building Heap from Unsorted array");
		for(int i=0;i<heap.unsortedArray.length;i++){System.out.print(heap.unsortedArray[i]);}
     //System.out.println("start");
		System.out.println();
		System.out.println("Heap sort implementation");
		heap.heapSort();
	}

}
