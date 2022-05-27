package RecursionQuestions;

public class LexographicSorting {

	public void pattern(int n, int i)
	{
		if(i>n)
			return;
		System.out.println(i);
		for(int j=(i==0?1:0);j<=9;j++)
		{
			pattern(n,(10*i)+j);
		}
	}
	
	
	public static void main(String[] args) {
		LexographicSorting ls=new LexographicSorting();
		ls.pattern(100, 0);

	}

}
