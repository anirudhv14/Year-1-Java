package satckAndQueues;

public interface DQueue 
{
	public void enqueuefront(int v);
	public void enqueuerear(int v);
	public int dequeuefront();
	public int dequeuerear();
	public boolean isEmpty();
	public void print();
	public int size();
}
