package satckAndQueues;

public class circularDQueue implements DQueue 
{
	int queue[],front,rear,f1,r1,f2,r2;
	
	public circularDQueue(int size)
	{
		queue=new int[size];
		front=rear=-1;
		f2=0;
		r2=size-1;
		f1=r1=-1;
	}

	public void enqueuefront(int v) //
	{
		if(isFull())
			System.out.println("Overflow!!!");
		else if(isEmpty1())
		{
			queue[queue.length-1]=v;
			f1=r1=queue.length-1;
		}
		else
				queue[r1=(r1-1)%queue.length]=v;
	}

	public void enqueuerear(int v)
	{
		if(isFull())
			System.out.println("Overflow!!!");
		else if(isEmpty())
		{
			queue[0]=v;
			front=rear=0;
		}
		else
			queue[rear=(rear+1)%queue.length]=v;
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
			int f=queue[front];
			front=(front+1)%queue.length;
			queue[front]=0;
			return f;
		}
	}

	public int dequeuerear() //
	{
		if(isEmpty())
		{
			System.out.println("Underflow!!!");
			return -999;
		}
		else if(f1==r1)
		{
			int l=front;
			r1=f1=-1;
			return queue[l];
		}
		else
		{
			int f=queue[f1];
			f1=(java.lang.Math.abs(f1-1))%queue.length;
			queue[f1]=0;
			return f;
		}
	}

	public boolean isFull() 
	{
		return ((rear+1)%queue.length==front)||((r1-1)%queue.length==f1);
	}

	public boolean isEmpty() 
	{
		return front<0;
	}
	
	public boolean isEmpty1() 
	{
		return f1<0;
	}

	public void print() 
	{
		if(!isEmpty())
		{
			for(int i=f2;i<=r2;i++)
				System.out.print(queue[i]+"\t");
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		circularDQueue o=new circularDQueue(7);
		o.enqueuefront(1);o.print();
		o.enqueuefront(2);o.print();
		o.enqueuefront(3);o.print();
		o.enqueuerear(4);o.print();
		o.enqueuerear(5);o.print();
		o.enqueuerear(6);o.print();
		
		
		System.out.println();
		System.out.println(o.dequeuefront()+" from front");o.print();
		System.out.println();
		System.out.println(o.dequeuerear()+" from rear");o.print();
		System.out.println();
		System.out.println(o.dequeuerear()+" from rear");o.print();
		System.out.println();
		System.out.println(o.dequeuerear()+" from rear");o.print();
		System.out.println();
		System.out.println(o.dequeuefront()+" from front");o.print();
		System.out.println();
		System.out.println(o.dequeuefront()+" from front");o.print();
		System.out.println();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}