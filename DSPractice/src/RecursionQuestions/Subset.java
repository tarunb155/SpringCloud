package RecursionQuestions;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Subset {
public void pattern(int ar[],int i,int n, String osf)
{
	if(i==n)
	{
		System.out.println("["+osf+"]");
		return;
	}
	pattern(ar, i+1, n, osf+ Integer.toString(ar[i])+",");
	pattern(ar, i+1, n, osf);
	
		
}
	
	
	
public static void main(String[] args) {
		System.out.println("Enter number of elements in the array");
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
		ar[i]=	sc.nextInt();
		}
		Subset s= new Subset();
		s.pattern(ar,0,n, "");
	}
	
}
