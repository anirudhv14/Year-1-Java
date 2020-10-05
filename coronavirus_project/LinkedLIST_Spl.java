package coronavirus_project;

/*
 * The following linked list is a special linked list for the following problem.
 * It has a String and a Hashlist in each node. This is used to store the cases 
 * in each country, 
 */
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
	
	// append() - function to add nodes to the linked list
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
	
	/*
	 * appendHList() - function to append the HashList  to the 
	 * specific node in the Linked List 
	 */
	public void appendHList(String v,String v1,String v2,String v3,LinkedLIST_Spl ll)
	{
		ll.last.hmap.put(v,null,v1,v2,v3);
	}
	
	// isEmpty() - function to check whether the linked list is empty
	public boolean isEmpty()
	{
		return (start==null);
	}

	/*
	 *  search() - function to search and return the total cases for 
	 *  the date in a particular country.
	 */
	public String[] search(String name, String date)
	{
		LinkedLIST_Spl.Node ptr = search(name);
		String arrAll[] =new String[3];
		for(int i = 0;i < ptr.hmap.arr.size;i++)
		{
			if(ptr.hmap.arr.arr[i].equalsIgnoreCase(date))
			{

				if(i != 0)
				{
					String arrAll1[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[i]));
					String arrAll2[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[i-1])); 

					for(int j = 0; j<arrAll.length ; j++)
						arrAll[j] = Integer.toString(Integer.parseInt(arrAll1[j])-Integer.parseInt(arrAll2[j]));
				}
				else
					arrAll = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[i]));
			}
		}
		return arrAll;
	}

	/*
	 *  search() - searches the linked list for the node and 
	 *  returns the node(if found).
	 */
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
