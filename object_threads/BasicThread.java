package object_threads;

public class BasicThread extends Thread
{
	public BasicThread(String name)
	{
		super(name);
		
	}
	public void run()
	{
		for(int i=0;i<10;i++)
			System.out.println(getName()+" "+(i+1));
	}
	public static void main(String srgs[])
	{
		BasicThread t1=new BasicThread("T1");
		BasicThread t2=new BasicThread("T2");
		BasicThread t3=new BasicThread("T3");
		System.out.println("Invoking thread...:");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Back to main...!!...");
		for(int i=0;i<10;i++)
			System.out.println("Main "+(i+1));
	}
}