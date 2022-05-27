package StringQuestions;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s)
	{
		int maxlength=1;
		int len= s.length();
		int start=0;
		
	for(int i=1;i<=len;i++)
		{
		//even case
			if(len%2==0)
			{
			int	l=i-1 ;
			int r=i;  
			while(l>=0 && r<len && s.charAt(l)==s.charAt(r))
			{	
				if(r-l+1>maxlength)
				{
					maxlength=r-l+1;
					start=l;
				}
					l=l-1;
					r=r+1;
				
			}
			
		}
		//odd case
			else if((len%2)!=0)
			{
				int	l=i-1 ;
				int r=i+1; 
				while(l>=0 && r<len && s.charAt(l)==s.charAt(r))
				{	
					if(r-l+1>maxlength)
					{
						maxlength=r-l+1;
						start=l;
					}
						l=l-1;
						r=r+1;
					
				}
				
			}
			
		}
	return s.substring(start, start+maxlength);
	}
	
	
	public static void main(String[] args) {
		String str="abb";
				LongestPalindromicSubstring lps= new LongestPalindromicSubstring();
		String longSubstring=lps.longestPalindrome(str);
		System.out.println("Longest Palindromic Substring is "+ longSubstring);
	}

}
