package satckAndQueues;

class queueDLL implements Queues
{
	class Node
	{
		int data;
		Node next,prev;
		public Node(int d)
		{
			data=d;
			next=prev=null;
		}
	};

	Node front=null,rear=null;
	public void enqueue(int v) 
	{
		if(isEmpty())
			front=rear=new Node(v);
		else
		{
			rear.next=new Node(v);
			rear=rear.next;
		}
	}

	public int dequeue() 
	{
		if(isEmpty())
		{
			System.out.println("Underflow!!!");
			return -999;
		}
		else
		{
			if(front==null)
			{
				System.out.println("StackUnderflowException!!");
				return -1;
			}
			Node temp=front;
			front=front.next;
			return temp.data;
		}
	}

	public boolean isEmpty()
	{
		return front==null;
	}

	public void print() 
	{
		for(Node p=front;p!=null;p=p.next)
			System.out.print(p.data+"\t");
		System.out.println();
	}

	public static void main(String args[])
	{
		queueDLL o=new queueDLL();
		o.enqueue(1);o.print();
		o.enqueue(2);o.print();
		o.enqueue(3);o.print();
		o.enqueue(4);o.print();
		o.enqueue(5);
		o.print();
		System.out.println();
		System.out.println(o.dequeue());o.print();
		System.out.println(o.dequeue());o.print();
		System.out.println(o.dequeue());o.print();
		System.out.println(o.dequeue());o.print();
		System.out.println(o.dequeue());o.print();
		System.out.println(o.dequeue());o.print();
		System.out.println();
		o.enqueue(1);o.print();
		o.enqueue(2);o.print();
		o.enqueue(3);o.print();
	}

}
