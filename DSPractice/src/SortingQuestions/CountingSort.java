package SortingQuestions;
import java.util.Scanner;

public class CountingSort {
static void countSort(int A[],int B[],int k)
{
	int[] C = new int[k+1];
	for(int i=0;i<=k;i++)
	{
		C[i]=0;
	}
	
	for(int j=1;j<A.length;j++)
	{
		C[A[j]]=C[A[j]]+1;
	}
	for(int i=1;i<=k;i++)
	{
		C[i]=C[i]+C[i-1];
	}
	for(int j=A.length-1;j>=1;j--)
	{
		B[C[A[j]]]=A[j];
		C[A[j]]=C[A[j]]-1;		
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

		
		int[] B=new int[n+1];
		int max=A[1];
		
		int i=1;
		int k;
		int j=i+1;
		
		while(i<n-1)
		{
			if(A[j]>max)
			{
				max=A[j];
			}
			
			i++;
			j++;
		}
		k=max;
		
		countSort(A,B,k);
		
		System.out.println("Sorted Array elements are: ");  
		 
		for (int p=1; p<=n; p++)   
		{  
		System.out.println(B[p]);  
		}  
	     

		
	}

}
