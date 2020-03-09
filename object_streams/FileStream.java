package object_streams;
import java.io.*;
public class FileStream
{
	public static void main(String args[])throws IOException
	{
		write();
		read();
	}
	public static void write()throws FileNotFoundException
	{
		PrintStream ps=new PrintStream(new FileOutputStream("Text.txt"));
		ps.println("Ram,\"Hi. How are you?\"");
		ps.println("Sam,\"Very fine.!\"");
		ps.println("Sam,\"You?...\"");
		ps.println("Ram,\"Oh! I am great!!!\"");
		ps.close();
	}
	public static void read()throws FileNotFoundException,IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("Text.txt"));
		String nextLine=br.readLine();
		while(nextLine!=null)
		{
			System.out.println(nextLine);
			nextLine=br.readLine();
		}
		br.close();
	}
}