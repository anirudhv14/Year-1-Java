package satckAndQueues;

public class circularQueueArray implements Queues
{
	int queue[],front,rear;
	
	public circularQueueArray(int size)
	{
		queue=new int[size];
		front=rear=-1;
	}
	
	public void enqueue(int v)
	{
		if((rear+1)%queue.length==front)
			System.out.println("Overflow!!!");
		else if(isEmpty())
		{
			queue[0]=v;
			front=rear=0;
		}
		else
				queue[rear=(rear+1)%queue.length]=v;
	}

	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Underflow!!!");
			return -999;
		}
		else if(front==rear)
		{
			int l=front;
			front=rear=-1;
			return queue[l];
		}
		else
		{
			int f=front;
			front=(front+1)%queue.length;
			return queue[f];
		}
	}

	public boolean isEmpty() 
	{
		return front<0 ;
	}

	public void print() 
	{
		if(!isEmpty())
		{
			for(int i=front;i!=rear;i=((i+1)%queue.length))
				System.out.print(queue[i]+"\t");
			System.out.print(queue[rear]+"\n");
		}
	}
	
	public static void main(String args[])
	{
		circularQueueArray o=new circularQueueArray(5);
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