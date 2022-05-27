package StringQuestions;

public class MinMax {

	public static void main(String[] args) {
		int ar[]= {17,9,61,33,41,2,72,28,55,16};
		int n=ar.length;
		int max=ar[0];
		for(int i=0;i<n;i++)
		{
			if(ar[i+1]>max)
			{
				max=ar[i+1];
				i++;
			}
			else
			{
				i++;
			}
		}
		
		System.out.println("maximum element is"+ max);

	}

}

