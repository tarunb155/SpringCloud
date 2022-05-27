package PriorityQueue;

import java.util.PriorityQueue;

public class KthLargest {

	public int findKthmax(int a[],int k)
	{
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		for(int i=0; i<k; i++)
		{
			pq.add(a[i]);
		}
		for(int i=k; i<a.length;i++)
		{
			if(a[i]>pq.peek())
			{
				pq.poll();
				pq.add(a[i]);
			}
		}
		return pq.peek();
	}
	
	public static void main(String[] args) {
    int t=3;
    int ar[]= {67,23,45,12,19,11,56,4};
    KthLargest kth= new KthLargest();
   int kthlarg= kth.findKthmax(ar, t);
    System.out.println("Kth largest element is "+kthlarg);

	}

}
