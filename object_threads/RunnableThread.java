package object_threads;
public class RunnableThread implements Runnable 
{
	String name;
	public RunnableThread(String n) 
	{
		name = n;

	}
	public void run()
	{
		for (int i = 0; i < 10; i++)
			System.out.println(name + " " + (i + 1));
	}
	public static void main(String args[]) 
	{
		Runnable r1 = new RunnableThread("R1");
		Runnable r2 = new RunnableThread("R2");
		Runnable r3 = new RunnableThread("R3");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		System.out.println("Invoking thread....");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Back to main");
		for (int i = 0; i < 10; i++)
			System.out.println("Main " + (i + 1));
	}
}