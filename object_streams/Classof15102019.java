package object_streams;
import java.io.*;
public class Classof15102019 
{
	public static void main(String args[])throws IOException
	{
		InputStream cin=System.in;
		InputStreamReader cr=new InputStreamReader(cin);
		BufferedReader in=new BufferedReader(cr);
		String a[]=new String[5];
		System.out.println("Enter the 5 words:");
		for(int i=0;i<5;i++)
		{
			a[i]=in.readLine();
		}
		for(int i=0;i<5;i++)
		{
			System.out.println("The entered word is:"+a[i]);
		}
		in.close();
		
	}
}