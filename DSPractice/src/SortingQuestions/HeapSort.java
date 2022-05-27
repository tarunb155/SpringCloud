package SortingQuestions;

import java.util.Scanner;

public class HeapSort {
	
	
	public static void h_Sort(int A[],int n) {
		for(int i=n/2;i>=1;i--)
		{
			max_heapify(A,n,i);
		}
		for(int i=n;i>=1;i--)
		{
			int temp;
			temp=A[1];
			A[1]=A[i];
			A[i]=temp;
			max_heapify(A,n,1);
		}
		
	}
	
	public static void max_heapify(int A[],int n, int i)
	{
		int largest=i;
		int l=2*i;
		int r=(2*i) + 1;
		while(l<=n && A[l]>A[largest])
		{
			largest=l;
		}
		while(r<=n && A[r]>A[largest])
		{
			largest=r;
		}
		if(largest!=i)
		{
			int temp;
			temp=A[largest];
			A[largest]=A[i];
			A[i]=temp;
			max_heapify(A,n,largest);
		}
	}
 
	public static void main(String[] args) {
	
		
		System.out.println("Enter the number of elements you have in your array\n\n");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] A=new int[n+1];
		A[0]=n;
		System.out.println("\n\nEnter array elements");
		for(int i=1;i<=n;i++)
		{
			A[i]=sc.nextInt();
		}
		
		h_Sort(A,n);
		
		System.out.println("Sorted Array elements are: ");  
		 
		for (int p=1; p<=n; p++)   
		{  
		System.out.println(A[p]);  
		}  

	}

}
