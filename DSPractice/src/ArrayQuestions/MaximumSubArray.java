//Kadane's Algorithm for finding the sum of maximum subarray

package ArrayQuestions;

public class MaximumSubArray {
	
	public int maxSubArray(int[] ar) {
        int maxSub = 0, curSum = 0;
        
        for (int i=0;i<ar.length;i++) {  //or use for(int i : ar)
            if (curSum < 0)
            {
                curSum = 0;
            }
            curSum = curSum + ar[i];// curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }
public static void main(String[] args) {
		
	MaximumSubArray m1=new MaximumSubArray();
	int nums[]= {-2,1,-3,4,-1,2,1,-5,4};
	int p=m1.maxSubArray(nums);
	System.out.println(p);
	}
}
