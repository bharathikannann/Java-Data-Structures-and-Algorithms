package com.company;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        StackLL s = new StackLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.pop();
        s.pop();
        s.peek();
        s.display();
    }
}
