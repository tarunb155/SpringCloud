package StringQuestions;

public class ReverseWordbyWord {
	
	public String printReverse(String str)
	{
		String splittedString[]=str.split(" ");
		String newString="";
		String nstr=" ";
		for(int i=0;i<splittedString.length;i++)
		{
			
			char ch;
			for(int j=0; j<splittedString[i].length();j++);
			{
			ch=splittedString[i].charAt(i);
			nstr=ch+nstr;
			}
		}
		return str;
	}
	
	
	public String reverseWords(String s) {
        String [] check = s.split(" ");
        String samp ="";
        for(int i=check.length-1;i>=0;i--){
            if(check[i].length()==0){
                continue;
            }
            if(i!=0){
                samp+= check[i] + " ";
            }else{
                samp+= check[i];
            }
        }
        char [] ans = samp.toCharArray();
        samp ="";
        for(int i=0;i<ans.length;i++){
            if(i==ans.length-1 && ans[i]==' '){
                continue;
            }
            samp+=ans[i];
        }
        return samp;
    }

	public static void main(String[] args) {
		ReverseWordbyWord rww= new ReverseWordbyWord();
		String newString=rww.reverseWords("tarun bhatt is good boy");
		System.out.println(newString);
	}

}
