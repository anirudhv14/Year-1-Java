package object_interface;

public class Assignment_Set2_008 
{
	public static void main(String args[])
	{
		int load1=10,F=0,ten=0;
		rope r1=new rope(load1);
		pully p1=new pully(1,load1)
		{
			public int loaderectedpully() 
			{
				return 0;
			}
			
		};
		if(p1.loaded())
			ten+=r1.tension();
		rope r2=new rope(ten);
		pully p2=new pully(1,0)
		{
			public int loaderectedpully() 
			{
				return 0;
			}
			
		};
		if(p2.erected())
			ten+=r2.tension();
		F=ten;
		System.out.println(F);
	}
}
interface Entity
{
	public int loadloadedpuly();
	public int loaderectedpully();}
class rope
{
	int loadp;
	public rope(int k)
	{
		loadp=k;	}
	public int tension()
	{
		return loadp;
	}
}
abstract class pully implements Entity
{
	int numofropes,loadp;
	public pully(int nor,int loadp)
	{
		numofropes=nor;
		this.loadp=loadp;
	}
	public boolean loaded()
	{
		if(numofropes>=0&&loadp!=0)
			return true;
		else
			return false;
	}
	public boolean erected()
	{
		if(numofropes==1&&loadp==0)
			return true;
		else 
			return false;
	}
	public int loadloadedpuly()
	{
		return loadp;
	}
	public abstract int loaderectedpully();	
}