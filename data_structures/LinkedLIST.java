package data_structures;

public class LinkedLIST implements Seq
{
	class Node
	{
		int data;
		Node next;
		public Node(int d)
		{
			data=d;
			next=null;
		}
		public int getData()
		{
			return data;
		}
		public Node getNode()
		{
			return next;
		}
	};
	Node start,last;
	public LinkedLIST() 
	{
		start=last=null;
	}
	public void append(int d)
	{
		if(isEmpty())
			start=last=new Node(d);
		else
		{
			last.next=new Node(d);
			last=last.next;
		}
	}
	public boolean isEmpty()
	{
		return (start==null);
	}
	public void print()
	{
		for(Node p=start;p!=null;p=p.next)
			System.out.print(p.data+"\t");
		System.out.println();
	}
	public void insert(int pos,int val)
	{
		int ctr=1;
		for(Node p=start;p!=null;p=p.next,ctr++)
		{
			if(ctr==pos)
			{
				Node temp=new Node(val);
				temp.next=p.next;
				p.next=temp;
				
			}
		}
	}
	public void delete(int pos)
	{
		int ctr=1;
		pos=pos-1;
		for(Node p=start;p!=null;p=p.next,ctr++)
		{
			if(ctr==pos)
			{
				Node temp=p.next;
				p.next=temp.next;
			}
		}
	}
	public int search(int val)
	{
		int f=0,ctr=0;
		for(Node p=start;p!=null;p=p.next,ctr++)
		{
			if(p.getData()==val)
			{
				f=1;
				break;
			}
		}
		if(f==1)
			return ++ctr;
		else
			return -1;
	}
}
