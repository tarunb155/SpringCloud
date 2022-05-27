package StackQuestions;

class main {
    public static void main(String args[])
    {
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.pop() + " Popped from stack");
        
    }
}
