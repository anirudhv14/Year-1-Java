package data_structures;

public class LL_2
{
	class Node
	{
		String data;
		Node next;
		public Node(String d)
		{
			data=d;
			next=null;
		}
		public String getData()
		{
			return data;
		}
		public Node getNode()
		{
			return next;
		}
	}
	;
	Node start,last;
	public LL_2() 
	{
		start=last=null;
	}
	public void append(String d)
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
			System.out.print(p.data+"\n");
		System.out.println();
	}
	public void insert(int pos,String val)
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
	public void searchAndDisplay(String val) throws NullPointerException
	{
		Node z=start;
		String s="";
		int f=0;
		while(z!=null)
		{
			s=z.getData();
			int k=s.indexOf(val);
			if(k!=-1)
			{
				System.out.println(s);
				f=1;
			}
			z=z.next;
		}
		if(f==0)
			System.out.println("ERROR!! The entered string is not present in the logsample.");
	}
	public String[] sortingTimeStamp()
	{
		String sts[]=new String[73];
		Node z=start;
		int ctr=0;
		while(z!=null)
		{
			sts[ctr]=z.getData();
			z=z.next;
		}
		return sts;
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
	public int search(String val)
	{
		int f=0,ctr=0;
		for(Node p=start;p!=null;p=p.next,ctr++)
		{
			if((p.getData()).equalsIgnoreCase(val))
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
