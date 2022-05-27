package ArrayQuestions;

public class ClosestSum {

	public void findClosestSum(int a[],int x)
	{
		int min_diff=Integer.MAX_VALUE;
		int n=a.length;
		int l=0;
		int r=n-1;
		int res_l=0, res_r=0;
		while(l<r)
		{
			if(Math.abs(a[l]+ a[r]-x)<min_diff)
			{
				res_l=l;
				res_r=r;
				min_diff=Math.abs(a[l]+ a[r]-x);
			}
			
			if(a[l]+a[r]>x)
			{
				r--;		
			}
			else
			{
				l++;
			}
		}
		System.out.println(" The closest pair is "+a[res_l]+" and "+ a[res_r]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestSum cs= new ClosestSum();
		int ar[]= {10,22,28,29,30,40};
		cs.findClosestSum(ar, 54);
	}

}
