package coronavirus_project;

public class LinkedLIST_Spl
{
	class Node
	{
		HashList hmap;
		String name;
		Node next;
		final static int DEFAULT_SIZE = 20;
		public Node(String n)
		{
			hmap = new HashList(DEFAULT_SIZE);
			name = n;
		}
		public Node(String n,int size)
		{
			hmap = new HashList(size);
			name = n;
		}
		
		
	};
	Node start,last;
	public LinkedLIST_Spl() 
	{
		start=last=null;
	}
	public void append(String n)
	{
		if(isEmpty())
			start=last=new Node(n);
		else
		{
			last.next=new Node(n);
			last=last.next;
		}
	}
	public void appendHList(String v,String v1,String v2,String v3,LinkedLIST_Spl ll)
	{
		ll.last.hmap.put(v,null,v1,v2,v3);
	}
	public boolean isEmpty()
	{
		return (start==null);
	}

	public String[] search(String name, String date)
	{
		LinkedLIST_Spl.Node ptr = search(name);
		String arrAll[] =new String[3];
		for(int i = 0;i < ptr.hmap.arr.size;i++)
		{
			if(ptr.hmap.arr.arr[i].equalsIgnoreCase(date))
				arrAll = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[i]));
		}
		return arrAll;
	}
		
	public Node search(String val)
	{
		int f=0;
		Node p;
		for(p=start;p!=null;p=p.next)
		{
			if(p.name.equalsIgnoreCase(val))
			{
				f=1;
				break;
			}
		}
		if(f==1)
			return p;
		else
			return null;
	}

}
