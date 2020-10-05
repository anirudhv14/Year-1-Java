package coronavirus_project;

/*
 * The following class is an Array datastructure which  can append to any length 
 * and automatically updates the length when it runs out of storage.
 */
public class Array 
{
	String arr[];
	int size;
	final static int DEF_LENGTH =100;
	public Array()
	{
		arr=new String[DEF_LENGTH ];
		size=0;
	}

	public Array(int newsize)
	{
		arr=new String[newsize];
		size=0;
	}

	public void append(String i)
	{
		if(isEmpty())
			arr[0]=i;
		if(size!=arr.length)
			arr[size++]=i;
		else
		{
			String abc[]=new String[2*arr.length];
			for(int w=0;w<arr.length;w++)
			{
				abc[w]=arr[w];
			}
			arr=abc;
			arr[size++]=i;
		}

	}
	
	public void print() 
	{
		for(int i=0;i<size;i++)
			System.out.println(arr[i]);
		System.out.println();
	}

	public boolean isEmpty()
	{
		return size==0;
	}

	public void delete(int pos) 
	{
		for(int i=0;i<size-1;i++)
		{
			if(i>=pos-1)
				arr[i]=arr[i+1];
		}
		size--;
	}

	public void insert(int pos, String val) 
	{
		String temp[]=new String[size];
		for(int i=0;i<size;i++)
		{
			temp[i]=arr[i];
		}
		for(int i=0;i<=size;i++)
		{
			if(i==pos-1)
				arr[i]=val;
			else if(i>=pos-1)
				arr[i]=temp[i-1];
		}
		size++;
	}

	public int search(String val) 
	{
		int ctr=-1;
		for(int i=0;i<size;i++)
		{
			if(arr[i].equals(val))
			{
				ctr=i+1;
				break;
			}
		}
		return ctr;
	}

	public String ind(int ii)
	{
		return arr[ii];
	}

	public int lengthh()
	{
		return size;
	}
}
