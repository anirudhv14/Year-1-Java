package data_structures;

public class DoublyLinkedLIST 
{
	class Node
	{
		int data;
		Node next;
		Node prev;
		public Node(int d)
		{
			data=d;
		}
	};
	
	Node start=null,end=null;
	int size=0;
	
	public void append(int val)
	{
		if(isEmpty())
		{
			start=end=new Node(val);
			start.prev=null;
			end.next=null;
			size++;
		}
		else
		{
			end.next=new Node(val);
			end.next.prev=end;
			end=end.next;
			size++;
		}
	}
	
	public void insert(int val,int ind)
	{
		if(ind!=-1)
		{
			int ctr=0;
			for(Node p=start;p!=null;p=p.next,ctr++)
			{
				if(ctr==ind)
				{
					Node temp = new Node(val);
			        temp.next = p.next;
			        p.next = temp;
			        temp.prev = p;
			        temp.next.prev = temp;
			        size++;
				}
			}
		}
		else
			System.out.println("Enter a valid index!!!");
	}
	
	public void delete(int ind)
	{
		if(isEmpty())
			System.out.println("Underflow!!! No data left in list to delete!!");
		else
		{
			if(ind==0)
			{
				start=start.next;
				size--;
			}
			else if(ind==size-1)
			{
				end=end.prev;
				size--;
			}
			else
			{
				int ctr=0,f=0;;
				for(Node p=start;p!=null;p=p.next,ctr++)
				{
					if(ctr==ind)
					{
						p=p.next;
						if(p.next!=null)
							p.next=p.next.next;
						p.next.prev=p;
						p=null;
						size--;
						f=1;
					}
				}
				if(f!=1)
					System.out.println("The given index does not exist");
			}
		}
	}
	
	public boolean isEmpty()
	{
		return start==null;
	}
	
	public void print()
	{
		for(Node p=start;p!=null;p=p.next)
			System.out.print(p.data+"\t");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		DoublyLinkedLIST o=new DoublyLinkedLIST();
		o.append(1);
		o.append(2);
		o.append(3);
		o.insert(42,0);
		o.insert(12,1);
		o.insert(13,2);
		o.append(12);
		o.print();
		
		o.delete(0);
		o.print();
		
	}
}
