package RecursionQuestions;

public class DicePath {

	public void pattern(int n, int i, String osf)
	{
		if(i>=n)
			return;
		if(i==n-1)
		{
			System.out.println(osf);
			return;
		}
		pattern(n, i+1, osf+ Integer.toString(1)  +"->");
		pattern(n, i+2, osf+ Integer.toString(2)  +"->");
		pattern(n, i+3, osf+ Integer.toString(3)  +"->");
		pattern(n, i+4, osf+ Integer.toString(4)  +"->");
		pattern(n, i+5, osf+ Integer.toString(5)  +"->");
		pattern(n, i+6, osf+ Integer.toString(6)  +"->");
		
			
	}
	
	
public static void main(String[] args) {
		
		DicePath dp= new DicePath();
		dp.pattern(3, 0, "");
	}
	
}
