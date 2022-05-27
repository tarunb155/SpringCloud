package StackQuestions;

public class Stack {
	
	int ar[];
	int top;
	int size;
	Stack(int size)
	{
		this.ar=new int[size];
		this.size=size;
		this.top=top;
	}
	public void push(int x)
	{
		if(isFull())
			{
			throw new RuntimeException("Stack is Full"); 
			}
		ar[++top]=x;
		System.out.println("Elment pushed to stack is "+x);
		
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is Empty");
		}
		return ar[top--];
	}
	
	public Boolean isFull()
	{
		if(top==size-1)
			return true;
		else
			return false;
		
	}

	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		else 
			return false;
	}
	public void displayStack()
	{
		
		System.out.println("current stack is "+ ar);

	}
	
}
