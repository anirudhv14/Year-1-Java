package satckAndQueues;

public class circularDQ implements DQueue
{
	int queue[],front,rear;

	public circularDQ(int size)
	{
		queue = new int[size];
		front = rear = -1;
	}

	public boolean isEmpty() 
	{
		return front < 0;
	}

	public void enqueuerear(int v)
	{

		if ((rear + 1) % queue.length == front) 
		{
			System.out.println("Overflow!!!");

		} 
		else if (isEmpty())
		{
			front = rear = 0;
			queue[rear] = v;

		} 
		else 
		{
			queue[rear = (rear + 1) % queue.length] = v;
		}
	}

	public void enqueuefront(int v)
	{

		if ((rear + 1) % queue.length == front)
		{
			System.out.println("Overflow!!!");

		}
		else if (isEmpty())
		{
			front = rear = 0;
			queue[rear] = v;

		}
		else if(front==0)
		{

			queue[front = queue.length-1] = v;
		}
		else
		{
			queue[front = front - 1] = v;
		}
	}

	public int dequeuefront()
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

	public int dequeuerear()
	{

		if (isEmpty()) 
		{
			System.out.println("UnderFlow!!!");
			return 0;
		} 
		else if (rear == front)
		{
			int temp = queue[front];
			front = rear = -1;
			return temp;
		}
		else 
		{
			int temp = queue[rear];
			if(rear==0) 
			{
				rear = queue.length-1;
			}
			else 
			{
				rear = rear - 1;
			}
			return temp;

		}

	}

	public void print() 
	{

		if (isEmpty())
			return;
		for (int i = front; i != rear + 1; i = (i + 1) % queue.length)
			System.out.print(queue[i] + "\t");

		System.out.println();
	}
	
	public int size()
	{
		return queue.length;
	}

	public static void main(String[] args) {
		circularDQueue o = new circularDQueue(10);

		o.enqueuerear(1);o.print();
		o.enqueuerear(2);o.print();
		o.enqueuerear(3);o.print();
		o.enqueuefront(4);o.print();
		o.enqueuefront(5);o.print();
		o.enqueuefront(6);o.print();
		o.enqueuerear(7);o.print();
		o.enqueuerear(8);o.print();
		o.enqueuefront(9);o.print();
		o.enqueuefront(10);o.print();
		System.out.println();
		o.print();
		System.out.println();
		System.out.println();
		System.out.println(o.dequeuefront() + " from front");o.print();
		System.out.println(o.dequeuefront() + " from front");o.print();
		System.out.println(o.dequeuerear() + "  from rear");o.print();
		System.out.println(o.dequeuerear() + " from rear ");o.print();
		System.out.println();
		o.print();


	}

}
