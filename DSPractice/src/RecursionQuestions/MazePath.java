package RecursionQuestions;

public class MazePath {
//static int totalPaths=0;

	public void pattern(int i, int j, int n, int m,String osf)
	{
		if(i==n-1 && j==m-1)
		{
	//		totalPaths = totalPaths+1;;
			System.out.println(osf);
			return;
		}
		if(i>=n || j>=m)
		{
			return;
		}
		
		pattern(i,j+1,n,m,osf+"R");
		pattern(i+1,j,n,m,osf+"D");
	}
	
	
	
public static void main(String[] args) {
		
		MazePath mp= new MazePath();
		mp.pattern(0, 0, 3,3,"");
	//	System.out.println("Total number of Paths possible are "+ totalPaths);
	}
}
