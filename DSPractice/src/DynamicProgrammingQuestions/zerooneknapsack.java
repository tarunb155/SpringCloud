package DynamicProgrammingQuestions;

public class zerooneknapsack {

	static int max(int a, int b)
    {
          return (a > b) ? a : b;
    }
	int knapsack(int wt[],int val[], int W, int n)
	{
		int i,j;
		int t[][]=new int[n+1][W+1];
		for(i=0;i<n+1;i++)
		{
			for(j=0;j<W+1;j++)
			{
				if(i==0||j==0)
					t[i][j]=0;
				else if(wt[i-1]<=j)
					t[i][j]=max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);	
				else
				{
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[n][W];
	}
	
	
	
	public static void main(String[] args) {
		zerooneknapsack z= new zerooneknapsack();
		int val[] = { 60, 100, 120 };
	    int wt[] = { 10, 20, 30 };
	    int W = 50;
	    int n = val.length;
	    System.out.println( z.knapsack(wt,val,W,n));
	}

}
