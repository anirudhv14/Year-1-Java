package object_threads;
public class Pi implements Runnable 
{
	int rank;
	static int size=0;
	Thread container;
	double dx;
	private static Object monitor=new Object();
	static boolean isOver;
	static double pi=0;
	public Pi(int p)
	{
		rank=size++;
		dx=java.lang.Math.pow(10,p*-1);
		isOver=false;
	}
	public void start()
	{
		container=new Thread(this);// 'this' refers to the object that calls the start function. i.e the calling object.
		container.start();
	}
	public void run()
	{
		double sum=0;
		double L=(double)rank/(double)size;
		double U=(double)(rank+1)/(double)(size);
		for(double i=L;i<U;i+=dx)
		{
			sum+=1.0/(1.0+i*i);
		}
		synchronized(monitor)
		{
			pi+=sum*dx*4;
			isOver=true;
			monitor.notify();
		}
	}
	public static void compute(int p,int numThreads) throws InterruptedException
	{
		Pi[] arrayPi=new Pi[numThreads];
		for(int t=0;t<arrayPi.length;t++)
			arrayPi[t]=new Pi(p);
		for(int t=0;t<arrayPi.length;t++)
				arrayPi[t].start();
		wait(arrayPi);
	}
	@SuppressWarnings("static-access")
	public static void wait(Pi threads[]) throws InterruptedException
	{
		for(int i=0;i<threads.length;i++)
		{
			if(threads[i].isOver)
				synchronized(monitor)
				{
					monitor.wait(5000);
				}
		}
	}
	public static void main(String args[]) throws InterruptedException
	{
		Pi.compute(11,6);
		int i=0;
		while(i<30)
		{
			System.out.println(Pi.pi);
			Thread.sleep(1000);
		}
	}
}