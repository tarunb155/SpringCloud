package RecursionQuestions;

public class DisplayIncDecPattern {

	public void incDecPattern(int n)
	{
		if(n==1)
		{
			System.out.println(n);
			return;
		}
		System.out.println(n);
		incDecPattern(n-1);
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		DisplayIncDecPattern dec = new DisplayIncDecPattern();
		dec.incDecPattern(5);

	}

}
