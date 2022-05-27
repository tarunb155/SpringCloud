package RecursionQuestions;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
	
	public void pattern(String str, String osf)
	{
	if(str.length()==0)
	{
		System.out.println(osf);
		return;
	}
	Set<Character> s = new HashSet<Character>(); 
	for(int i=0;i<str.length();i++)
	{
		char ch= str.charAt(i);
		if(!s.contains(ch))
		{
		String ros=str.substring(0,i)+ str.substring(i+1);
		s.add(ch);
		pattern(ros,osf+ch);
		}
	}
		
	}
	
	
	public static void main(String[] args) {
		Permutation p=new Permutation();
		p.pattern("ABC", "");

	}

}
