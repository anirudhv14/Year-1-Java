package satckAndQueues;

public class stackList implements Stacks 
{
	class Node
	{
		int data;
		Node next;
		public Node(int d,Node n)
		{
			data=d;
			next=n;
		}
	}

	Node top=null;
	
	public void push(int e)
	{
		top=new Node(e,top);
	}

	public int pop() 
	{
		if(top==null)
		{
			System.out.println("StackUnderflowException!!");
			return -1;
		}
		Node temp=top;
		top=top.next;
		return temp.data;
	}

	public void print()
	{
		for(Node i=top;i!=null;i=i.next)
			System.out.print(i.data+"\t");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		stackList o=new stackList();
		o.push(1);
		o.push(2);
		o.push(3);
		o.push(4);
		o.push(5);
		o.push(6);
		o.print();
		System.out.println(o.pop());
		System.out.println(o.pop());
		System.out.println(o.pop());
		System.out.println(o.pop());
		System.out.println(o.pop());
		System.out.println(o.pop());
		o.print();
		System.out.println(o.pop());
		
	}
	
}