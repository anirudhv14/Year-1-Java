package object_interface;

public class Delegation 
{
	static EventListener eventArray[]=new EventListener[10];
	static int count=0;
	public static void main(String args[]) 
	{
		A a1=new A("Krish");
		A a2=new A("Anirudh");
		B b1=new B(1423);
		B b2=new B(2314);
		
		Delegation.register(a1);
		Delegation.register(b1);
		
		Delegation d1=new Delegation();
		
		System.out.println();
		Delegation.register(a2);
		Delegation.register(b2);
		
		Delegation d2=new Delegation();
	}
	public static void register(EventListener arr)
	{
		eventArray[count++]=arr;
	}
	public Delegation()
	{
		for(int i=0;i<count;i++)
		{
			eventArray[i].eventOccured();
		}
	}
}

interface EventListener
{
	public void eventOccured();
}

class A implements EventListener
{
	String name;
	public A(String n)
	{
		name=n;
	}
	public void eventOccured()
	{
		System.out.println(name+" of type A:"+"'WOW!!! Object created!'");
	}
}

class B implements EventListener
{
	int num;
	public B(int n)
	{
		num=n;
	}
	public void eventOccured()
	{
		System.out.println(num+" of type B:"+"'WOW!!! Object instantiated!'");
	}
}