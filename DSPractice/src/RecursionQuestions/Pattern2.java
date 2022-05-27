package RecursionQuestions;

public class Pattern2 {

	public void printPat(int n,int i)
	{
		int j=0;
		if(n==i)
			return;
		if(j<=i)
		{
			j++;
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
		
		Pattern2 p2=new Pattern2();
		p2.printPat(5, 0);
	}
}
