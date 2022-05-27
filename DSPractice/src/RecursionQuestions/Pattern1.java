package RecursionQuestions;

public class Pattern1 {

	void printPat(int n,int i)
	{
		//i denotes the current column
		//n denotes the input value passed which is basically the no of rows required in pattern 
		if(n==0)
			{
			return;
			}
		if(i<n)
		{	
			System.out.print("*");
			printPat(n,i+1);
		}
		else
		{
			System.out.println("\n");
			printPat(n-1, 0);
		}
		
	}
	
	public static void main(String[] args) {
		
		Pattern1 p1=new Pattern1();
		p1.printPat(5, 0);
	}
	
}
