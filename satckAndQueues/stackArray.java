package satckAndQueues;

public class stackArray implements Stacks 
{
	int stack[],top;
	
	public stackArray(int size)
	{
		stack=new int[size];
		top=-1;
	}
	public void push(int e) 
	{
		if(top+1==stack.length)
		{
			System.out.println("StackOverflowException!!");
			return;
		}
		stack[++top]=e;
	}

	public int pop() 
	{
		if(top<0)
		{
			System.out.println("StackUnderflowException!!");
			return -1;
		}
		return stack[top--];
	}

	public void print() 
	{
		for(int i=top;i>=0;i--)
			System.out.print(stack[i]+"\t");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		stackArray o=new stackArray(5);
		o.push(1);
		o.push(2);
		o.push(3);
		o.push(4);
		o.push(5);
		o.print();
		o.push(6);
		System.out.println(o.pop());
		System.out.println(o.pop());
		System.out.println(o.pop());
		System.out.println(o.pop());
		System.out.println(o.pop());
		o.print();
		System.out.println(o.pop());
	}
	
}